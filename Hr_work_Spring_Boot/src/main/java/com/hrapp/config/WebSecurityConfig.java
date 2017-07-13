package com.hrapp.config;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.hrapp.module.bootsecurity.controller.SimpleCORSFilter;
import com.hrapp.module.bootsecurity.service.GpBootSecurityUserService;

@Configuration
@EnableWebSecurity
@EnableAspectJAutoProxy(proxyTargetClass = true)
@CrossOrigin
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	private GpBootSecurityUserService userDetailsService;
	@Autowired
	private SimpleCORSFilter myCorsFilter;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/user/createsocialuser");

	}


	@Override

	protected void configure(HttpSecurity http) throws Exception {
		ExceptionMappingAuthenticationFailureHandler loginFailureHandler = new ExceptionMappingAuthenticationFailureHandler();
		loginFailureHandler.setDefaultFailureUrl("/login/loginFailure");
		
		http.authorizeRequests()
				.antMatchers("/", "/lib/**", "/angularjs/**").permitAll().and().formLogin()
				.usernameParameter("j_username").passwordParameter("j_password")
				.loginProcessingUrl("/j_spring_security_check")
				.successHandler(new RedirectingAuthenticationSuccessHandler()).permitAll()
				.failureHandler(loginFailureHandler).permitAll().and().logout().permitAll().and().exceptionHandling()
				.accessDeniedPage("/accessDenied/403").and().csrf().disable();

	}

	/*@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("https://localhost:4200/"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST","OPTION"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}*/

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
}