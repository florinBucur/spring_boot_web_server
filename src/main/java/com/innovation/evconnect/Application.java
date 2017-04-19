package com.innovation.evconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "com.innovation.evconnect.entities" }) 
@EnableJpaRepositories(basePackages = { "com.innovation.evconnect.repo" })

public class Application extends SpringBootServletInitializer 
{
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
	
	public static void main( String[] args ) {
		SpringApplication.run(Application.class, args);    
	}
}
