package com.nyoba.nyicilprojek.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/login", "/", "/auth/").permitAll()
                .requestMatchers("/css/**", "/js/**", "/img/**").permitAll()
                .requestMatchers("/admin/**")
                .hasAnyAuthority("ADMIN")
                .requestMatchers("/user/**").hasAuthority("USER")
                .requestMatchers("/bendahara/**").hasAnyAuthority("BENDAHARA","ADMIN")
                .requestMatchers("/sekretaris/**").hasAnyAuthority("SEKRETARIS","ADMIN")
                .requestMatchers("/ppmb/**").hasAnyAuthority("PPMB","ADMIN")
                .anyRequest().authenticated())
                .formLogin((form) -> form
                        .loginPage("/login").permitAll()
                        .defaultSuccessUrl("/").permitAll()
                        .successHandler(new AuthenticationSuccessHandler() {
                            public void onAuthenticationSuccess(HttpServletRequest request,
                                    HttpServletResponse response, Authentication authentication)
                                    throws IOException, ServletException {
                                System.out.println("Logged As: " + authentication.getName());
                                if(authentication.getName().equalsIgnoreCase("USER"))
                                    response.sendRedirect("/user/");
                                else if(authentication.getName().equalsIgnoreCase("ADMIN"))
                                    response.sendRedirect("/admin/");
                                else if(authentication.getName().equalsIgnoreCase("BENDAHARA"))
                                    response.sendRedirect("/bendahara/");
                                else if (authentication.getName().equalsIgnoreCase("SEKRETARIS"))
                                    response.sendRedirect("/sekretaris/");
                                else if (authentication.getName().equalsIgnoreCase("PPMB"))
                                    response.sendRedirect("/ppmb/");
                                else response.sendRedirect("/");
                            }
                        }))
                .logout((logout) -> logout
                        .logoutSuccessHandler(new LogoutSuccessHandler() {
                            public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                    Authentication authentication) throws IOException, ServletException {
                                System.out.println("User logged out: " + authentication.getName());
                                response.sendRedirect("/");
                            }
                        }))
                .exceptionHandling(exception->exception
                    .accessDeniedPage("/denied"));

        return http.build();
    }
}
