package com.testshop.config;

import com.testshop.constants.ApplicationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        authenticationMgr.inMemoryAuthentication()
                .withUser(ApplicationConstant.LOGIN_DOCTOR)
                .password(encoder.encode(ApplicationConstant.PASSWORD))
                .roles("ADMIN", "USER")
                .and()
                .withUser(ApplicationConstant.LOGIN_NURSE)
                .password(encoder.encode(ApplicationConstant.PASSWORD))
                .roles("USER");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**"); // #3
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/events/**").permitAll()
                .antMatchers("/GoodsManager/**").access("hasRole('ROLE_ADMIN')")
                .and()
                .formLogin()
                .loginPage("/index")
                .permitAll()
                .defaultSuccessUrl("/GoodsManager/")
                .failureUrl("/index")
                .usernameParameter("username").passwordParameter("password")
//                .and()
//                .authorizeRequests().
//                antMatchers("/events/**").access("hasAnyRole('ADMIN','USER')")
                .and()
                .formLogin().loginPage("/index")
                .defaultSuccessUrl("/GoodsManager/")
                .failureUrl("/index?error")
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/index?logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and()
                .exceptionHandling().accessDeniedPage("/accessDenied");
        http.authorizeRequests().antMatchers("/resources/css/**").permitAll();
    }
}

