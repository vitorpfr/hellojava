package com.example.bookstoredemo;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


// once the spring-boot-starter-security dependency is on the classpath of the application, all endpoints are secured,
// using either httpBasic or formLogin based on Spring Security's content negotiation strategy.

// that's why, if we have the starter on the classpath, we should usually define our own custom Security configuration
// by extending the WebSecurityConfigurerAdapter (done here)

// in this example, we are allowing unrestricted access to all endpoints
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .permitAll()
                .and().csrf().disable();
    }
}
