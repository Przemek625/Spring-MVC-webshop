package com.packt.webstore.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import javax.sql.DataSource;

/**
 * Created by Przemek on 2016-07-26.
 */

@Configuration
@EnableWebSecurity
@Import(DataConfig.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        /*language=SQL*/
        String SELECT_USER="SELECT username, password, 'true' FROM  users WHERE username=?";
        /*language=SQL*/
        String SELECT_ROLE_USER="SELECT username, 'ROLE_USER' FROM  users WHERE username=?" ;

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(SELECT_USER)
                .authoritiesByUsernameQuery(SELECT_ROLE_USER)
                .and()
                .inMemoryAuthentication()
                .withUser("ADMIN").password("a").roles("ADMIN");
        //need to repair it
                //.passwordEncoder(new StandardPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/customers/add").access("hasRole('USER') or hasRole('ADMIN')")
                .and()
                .formLogin().loginPage("/login").permitAll();
    }
}
