package com.innovation.evconnect.configurations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.innovation.evconnect.security.JWTAuthenticationFilter;
import com.innovation.evconnect.security.JWTLoginFilter;

@Configuration
@EnableWebSecurity(debug = false)
public class EvSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// disable caching
		http.headers().cacheControl();
		// disable csrf for our requests.
		http.csrf().disable().authorizeRequests()
				// allow the request to get to login service
				.antMatchers(HttpMethod.POST, "/login", "/signup","/logg").permitAll()
				.antMatchers(HttpMethod.GET, "/","/client-home.html","/admin-home.html","/admin-requests.html","/createRoom","/auth.html", "/register.html", "/locations","/js/**", "/materialize/**",
						"/style/**", "/images/**", "/dist/**", "/index.html", "/views/**")
				.permitAll()
				// enforce security for the rest of the calls
				.anyRequest().authenticated().and()
				// filter the api/login requests
				.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
						UsernamePasswordAuthenticationFilter.class)
				// And filter other requests to check the presence of JWT in
				// header
				.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// in memory authetication
		// auth.inMemoryAuthentication().withUser("test").password("test").roles("ADMIN");
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(new BCryptPasswordEncoder(12));

	}
}
