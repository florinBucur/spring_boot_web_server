package com.innovation.evconnect.configurations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DbConfig {
	@Autowired
	Environment env;
	
	@Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("myapp.dataSource.driver"));
        dataSource.setUrl(env.getProperty("myapp.dataSource.url"));
        dataSource.setUsername(env.getProperty("myapp.dataSource.username"));
        dataSource.setPassword(env.getProperty("myapp.dataSource.password"));
        return dataSource;
    }
}
