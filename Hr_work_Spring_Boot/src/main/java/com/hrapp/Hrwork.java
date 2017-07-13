package com.hrapp;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.hrapp.module.bootsecurity.controller.SimpleCORSFilter;

@EnableJpaRepositories({"com.hrapp.*"})
@EnableAutoConfiguration
@ComponentScan({"com.hrapp.*"})
@SpringBootApplication
public class Hrwork extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Hrwork.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(Hrwork.class, args);
	}
	@Bean
	public FilterRegistrationBean someFilterRegistration() {
	FilterRegistrationBean registration = new FilterRegistrationBean();
	registration.setFilter(simpleCORSFilter());
	registration.addUrlPatterns("/*");
	registration.setName("simpleCORSFilter");
	registration.setOrder(1);
	return registration;
}
 @Bean(name = "simpleCORSFilter") 
	public Filter simpleCORSFilter() {
	return new SimpleCORSFilter();
}
 
 @Bean
 public WebMvcConfigurer corsConfigurer() {
     return new WebMvcConfigurerAdapter() {
         @Override
         public void addCorsMappings(CorsRegistry registry) {
             registry.addMapping("/**").allowedOrigins("http://localhost:4200/");
         }
     };
 }

 }
