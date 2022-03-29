package com.codegym.security;

import com.codegym.service.impl.MyUserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfigs extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailServiceImpl myUserDetailService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return  new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(myUserDetailService)
                    .passwordEncoder(passwordEncoder());
    }
    @Override
    protected  void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .formLogin()
                .loginPage("/meet")
                .defaultSuccessUrl("/home").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/**").hasRole("ADMIN")
                .antMatchers("/customers/list", "/employees/list").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutSuccessUrl("/home");
    }
//    @Bean
//    public PersistencetO
}
