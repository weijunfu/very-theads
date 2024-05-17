package com.ijunfu.config;

import com.ijunfu.userDetails.DbUserDetailsManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @Title  : SpringSecurity配置类
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/15 10:07
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean("passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2Y, 10);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .formLogin((formLogin) -> formLogin.loginPage("/login").loginProcessingUrl("/login").permitAll())
                .logout((logout) -> logout.logoutSuccessUrl("/login"))
                .csrf((csrf) -> csrf.disable())
        ;

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(
            @Qualifier("userDetailsService") UserDetailsService userDetailsService,
            @Qualifier("passwordEncoder") PasswordEncoder passwordEncoder
    ) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);

        return authenticationProvider;
    }

    @Bean("userDetailsService")
    public UserDetailsService userDetailsService() {
        // 基于数据库的用户管理
        return new DbUserDetailsManager();
    }
}
