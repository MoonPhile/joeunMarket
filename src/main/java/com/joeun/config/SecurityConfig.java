package com.joeun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration  //스프링 시큐리티 환결설정
@EnableWebSecurity  //모든 요청 URL 시큐리티 제어를 받게하는 애노테이션 내부적으로 SpringSecurityFilterChain 동작하여 URL 필터 적용
@EnableMethodSecurity(prePostEnabled = true) // 인가 설정 08/08 04:46 (진석)
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/admin.do").hasRole("ADMIN")
                .requestMatchers(
                        new AntPathRequestMatcher("/**")).permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true);
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}

    @Bean   //스프링 시큐리티 인증 담당. 사용자 인증시 UserSecurityService와 PasswordEncoder를 사용
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
