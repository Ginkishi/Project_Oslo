package edu.uha.miage.config;

import edu.uha.miage.core.service.impl.UserDetailsServiceImpl;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

/**
 *
 * @author victo
 * @Modified Psyrkoz
 */
@Configuration
@EnableWebSecurity
@Profile("prod")
@Order(1)
public class WebSecurityConfigProd extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private UserDetailsServiceImpl userDetailService;
    
    @Autowired
    private DataSource dataSource;
    
    @Autowired
    public void configAuthentification(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService);
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
                .antMatchers("/administration").hasAuthority("ROLE_ADMIN")
                .antMatchers("/personne").hasAuthority("ROLE_ADMIN")
                .antMatchers("/compte").hasAuthority("ROLE_ADMIN")
                .antMatchers("/categorie").hasAuthority("ROLE_ADMIN")
                .antMatchers("/departement").hasAuthority("ROLE_ADMIN")
                .antMatchers("/domaine").hasAuthority("ROLE_ADMIN")
                .antMatchers("/fonction").hasAuthority("ROLE_ADMIN")
                .antMatchers("/incident").hasAuthority("ROLE_ADMIN")
                .antMatchers("/role").hasAuthority("ROLE_ADMIN")
                .antMatchers("/service").hasAuthority("ROLE_ADMIN")
                .antMatchers("/statutDemande").hasAuthority("ROLE_ADMIN")
                .antMatchers("/demandes").hasAnyAuthority("ROLE_ADMIN", "ROLE_INTERVENANT")
                .antMatchers("/demandes/**/cloture").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().permitAll();
    }
}
