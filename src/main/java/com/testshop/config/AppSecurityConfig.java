package com.testshop.config;

import com.testshop.constants.ApplicationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        authenticationMgr.inMemoryAuthentication()
//                .withUser(ApplicationConstant.LOGIN_DOCTOR)
//                .password(encoder.encode(ApplicationConstant.PASSWORD))
//                .roles("ADMIN", "USER")
//                .and()
//                .withUser(ApplicationConstant.LOGIN_NURSE)
//                .password(encoder.encode(ApplicationConstant.PASSWORD))
//                .roles("USER");
        authenticationMgr.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**"); // #3
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {// включаем защиту от CSRF атак
        http.csrf()
                .disable()
                // указываем правила запросов
                // по которым будет определятся доступ к ресурсам и остальным данным
                .authorizeRequests()
                .antMatchers("/GoodsManager/**").access("hasAnyRole('ADMIN','USER')")
                .antMatchers("/resources/**").permitAll()
                .and();

        http.formLogin()
                // указываем страницу с формой логина
                .loginPage("/index")
                // указываем action с формы логина
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/GoodsManager/")
                // указываем URL при неудачном логине
                .failureUrl("/login?error")
                // Указываем параметры логина и пароля с формы логина
                .usernameParameter("username")
                .passwordParameter("password")
                // даем доступ к форме логина всем
                .permitAll();

        http.logout()
                // разрешаем делать логаут всем
                .permitAll()
                // указываем URL логаута
                .logoutUrl("/logout")
                // указываем URL при удачном логауте
                .logoutSuccessUrl("/login?logout")
                // делаем не валидной текущую сессию
                .invalidateHttpSession(true);
    }
}

