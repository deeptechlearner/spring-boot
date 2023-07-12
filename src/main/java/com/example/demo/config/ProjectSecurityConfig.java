package com.example.demo.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    /**
     * From Spring Security 5.7, the WebSecurityConfigurerAdapter is deprecated to encourage users
     * to move towards a component-based security configuration. It is recommended to create a bean
     * of type SecurityFilterChain for security related configurations.
     *
     * @param http
     * @return SecurityFilterChain
     * @throws Exception
     */
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic().and()
                .authorizeHttpRequests()
                .requestMatchers("/v1/movie/add").hasRole("ADMIN")
                .requestMatchers("/v1/movie/modify").hasRole("ADMIN")
                .requestMatchers("/v1/movie/**").permitAll()
                .requestMatchers(PathRequest.toH2Console()).permitAll()
                .and().csrf().disable();
        http.formLogin().disable();
        http.headers().frameOptions().disable();

        return http.build();

    }

    @Bean
    InMemoryUserDetailsManager userDetailsService() {

        UserDetails user = User.withDefaultPasswordEncoder()
                .username("minion@gmail.com")
                .password("minion")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

}
