package com.hrapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.hrapp.module.bootsecurity.controller.SimpleCORSFilter;

import javax.servlet.Filter;

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

 }
