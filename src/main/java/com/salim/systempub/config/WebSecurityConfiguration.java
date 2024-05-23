package com.salim.systempub.config;

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

import com.salim.systempub.constant.AuthConstantHelper;
import com.salim.systempub.constant.ConstHelper;
import com.salim.systempub.constant.RolesConstant;

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
                .requestMatchers("/css/**", "/js/**", "/img/**").permitAll()
                .requestMatchers("/login", "/", "/auth/", "/about/", "/calladmin/**").permitAll()
                .requestMatchers("/admin/**").hasAuthority(RolesConstant.ADMIN)
                .requestMatchers("/user/**").hasAuthority(RolesConstant.USER)
                .requestMatchers("/bendahara/**").hasAnyAuthority("BENDAHARA", RolesConstant.ADMIN)
                .requestMatchers("/sekretaris/**").hasAnyAuthority("SEKRETARIS", RolesConstant.ADMIN)
                .requestMatchers("/ppmb/**").hasAnyAuthority("PPMB", RolesConstant.ADMIN)
                .requestMatchers("/divisi/")
                .hasAnyAuthority("DIVISI PENDIDIKAN DAN PELATIHAN", "DIVISI PELATIHAN BAHASA INGGRIS",
                        "DIVISI KEROHANIAN", "DIVISI KESEJAHTERAAN", "DIVISI KESEHATAN", "DIVISI KEASRAMAAN",
                        "DIVISI KEBERSIHAN", RolesConstant.ADMIN)
                .requestMatchers("/divisi/pendidikan/**")
                .hasAnyAuthority("DIVISI PENDIDIKAN DAN PELATIHAN", RolesConstant.ADMIN)
                .requestMatchers("/divisi/pelatihaninggris/**")
                .hasAnyAuthority("DIVISI PELATIHAN BAHASA INGGRIS", RolesConstant.ADMIN)
                .requestMatchers("/divisi/kerohanian/**").hasAnyAuthority("DIVISI KEROHANIAN", RolesConstant.ADMIN)
                .requestMatchers("/divisi/kesejahteraan/**")
                .hasAnyAuthority("DIVISI KESEJAHTERAAN", RolesConstant.ADMIN)
                .requestMatchers("/divisi/kesehatan/**").hasAnyAuthority("DIVISI KESEHATAN", RolesConstant.ADMIN)
                .requestMatchers("/divisi/keasramaan/**").hasAnyAuthority("DIVISI KEASRAMAAN", RolesConstant.ADMIN)
                .requestMatchers("/divisi/kebersihan/**").hasAnyAuthority("DIVISI KEBERSIHAN", RolesConstant.ADMIN)
                .anyRequest().authenticated())
                .formLogin((form) -> form
                        .loginPage("/login").permitAll()
                        .defaultSuccessUrl("/")
                        .successHandler(new AuthenticationSuccessHandler() {
                            public void onAuthenticationSuccess(HttpServletRequest request,
                                    HttpServletResponse response, Authentication authentication)
                                    throws IOException, ServletException {
                                AuthConstantHelper.username = authentication.getName();
                                ConstHelper.userRole = authentication.getAuthorities().iterator().next().getAuthority();
                                System.out.println("Logged As: "
                                        + ConstHelper.userRole);
                                String redirectUrl = "/";
                                switch (ConstHelper.userRole) {
                                    case RolesConstant.USER:
                                        redirectUrl = "/user/";
                                        break;
                                    case RolesConstant.ADMIN:
                                        redirectUrl = "/admin/";
                                        break;
                                    case RolesConstant.BENDAHARA:
                                        redirectUrl = "/bendahara/";
                                        break;
                                    case RolesConstant.SEKRETARIS:
                                        redirectUrl = "/sekretaris/";
                                        break;
                                    case RolesConstant.PPMB:
                                        redirectUrl = "/ppmb/";
                                        break;
                                    case RolesConstant.DIVISI_PENDIDIKAN_PELATIHAN:
                                        redirectUrl = "/divisi/pendidikan/";
                                        break;
                                    case RolesConstant.DIVISI_PELATIHAN_INGGRIS:
                                        redirectUrl = "/divisi/pelatihaninggris/";
                                        break;
                                    case RolesConstant.DIVISI_KEROHANIAN:
                                        redirectUrl = "/divisi/kerohanian/";
                                        break;
                                    case RolesConstant.DIVISI_KESEJAHTERAAN:
                                        redirectUrl = "/divisi/kesejahteran/";
                                        break;
                                    case RolesConstant.DIVISI_KEASRAMAAN:
                                        redirectUrl = "/divisi/keasramaan/";
                                        break;
                                    case RolesConstant.DIVISI_KEBERSIHAN:
                                        redirectUrl = "/divisi/kebersihan/";
                                        break;
                                    case RolesConstant.DIVISI_KESEHATAN:
                                        redirectUrl = "/divisi/kesehatan/";
                                        break;
                                }
                                response.sendRedirect(redirectUrl);
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
                .exceptionHandling(exception -> exception
                        .accessDeniedPage("/denied"));

        return http.build();
    }
}
