/*
 * Copyright (C) 2016 João Paulo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.joaops.awc.configuration;

import br.com.joaops.awc.security.AwcAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 *
 * @author João Paulo
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    private final String defaultSecret = "BQG^@MTMG948xCvQD^x$q?mwDkS2qz=yBkHRe_3tyGCY_?P4jMQ^!w^=j$S&2K9Q5VQV3uD5Grd*DVpc+jHzDFEUCc+X2vXPjbK4rt&GQxnbAVxqWh_N#Ew%eh4h#X9WfT$tfYN*7!rjzeEHj&DDV5R58Rv3kUrrk&qDZ3z=Y*!rQh?YRWU-8xP&mdqRD*h3S?GMEv?W&nS$LyTGv36ffGKyYeZC7Xm3CfWAXwHp^CYxgs5@Fw6Q9AHJBUTGzfC?";
    
    @Autowired
    private AwcAuthenticationProvider authenticatorProvider;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.eraseCredentials(true);
        auth.authenticationProvider(authenticatorProvider);
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resources/**");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**");
        
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/add").permitAll()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/logout/**").permitAll()
                .antMatchers("/home").authenticated()
                .anyRequest().authenticated();
        
        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login/check")
                .failureUrl("/login/error")
                .defaultSuccessUrl("/home", true)
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll();
        
        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");
        
        http.sessionManagement()
                .maximumSessions(1).and()
                .sessionFixation()
                .newSession();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        StandardPasswordEncoder encoder = new StandardPasswordEncoder(defaultSecret);
        return encoder;
    }
    
}