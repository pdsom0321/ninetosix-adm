package com.gsc.ninetosixadm.core.config;

import com.gsc.ninetosixadm.core.handler.CustomAccessDeniedHandler;
import com.gsc.ninetosixadm.core.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringSecurityConfig {
    private final CustomUserDetailsService customUserDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/images/**", "/js/**", "/css/**", "/fonts/**", "/icons/**", "/plugins/**", "/scss/**", "/webjars/**",
                        "/auth/**").permitAll()
                .antMatchers("/admin").hasAuthority("ROLE_ADMIN")
                .anyRequest().authenticated()

                // 시큐리티는 기본적으로 세션을 사용
                // 여기서는 세션을 사용하지 않기 때문에 세션 설정을 Stateless 로 설정
                .and()
                .sessionManagement()

                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/loginProc")
                .usernameParameter("id")
                .passwordParameter("pw")
                .defaultSuccessUrl("/admin", true)
                .permitAll()
                .and()
                .userDetailsService(customUserDetailsService)
                .exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler())
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logoutProc"));

        return http.build();
    }

    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web -> web.ignoring().antMatchers("/images/**", "/js/**", "/css/**", "/fonts/**", "/icons/**", "/plugins/**", "/scss/**", "/webjars/**"));
    }
}
