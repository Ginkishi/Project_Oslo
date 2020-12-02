/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

/**
 *
 * @author victo
 * @Modified Quentin
 */
@Configuration
@EnableWebSecurity
@Profile("prod")
@Order(1)
public class WebSecurityConfigProd extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    
    @Autowired
    public void configAuthentification(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT username, password, 'true' FROM compte WHERE username=?")
                .authoritiesByUsernameQuery("SELECT username, password, role_id FROM compte WHERE username=?");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/inscription").permitAll()
                .antMatchers("/static/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll();
        http.csrf().disable(); // TODO: Enlever quand csrf token present sur le page d'inscription!
    }
}
