package com.example.springapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.springapp.model.Permission;
import com.example.springapp.model.Role;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

  private final JWTAuthenticationFilter jwtAuthFilter = new JWTAuthenticationFilter();
  private final AuthenticationProvider authenticationProvider = null;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .cors()
        .and()
        .csrf()
        .disable()
        .authorizeRequests()
        .requestMatchers("/api/v1/auth/**").permitAll()
         .requestMatchers("/api/v1/user/**")
         .hasAnyRole(Role.USER.name(), Role.MANAGER.name())
         .requestMatchers(HttpMethod.GET, "/api/v1/user/**")
         .hasAnyAuthority(Permission.USER_READ.name(), Permission.MANAGER_READ.name())
         .requestMatchers(HttpMethod.POST, "/api/v1/user/**")
         .hasAnyAuthority(Permission.USER_CREATE.name(),
         Permission.MANAGER_CREATE.name())
         .requestMatchers(HttpMethod.PUT, "/api/v1/user/**")
         .hasAnyAuthority(Permission.USER_UPDATE.name(),
         Permission.MANAGER_UPDATE.name())
         .requestMatchers(HttpMethod.DELETE, "/api/v1/user/**")
         .hasAnyAuthority(Permission.USER_DELETE.name(),
         Permission.MANAGER_DELETE.name())
         .requestMatchers("/api/v1/manager/**").hasRole(Role.MANAGER.name())
         .requestMatchers(HttpMethod.GET,
         "/api/v1/manager/**").hasAuthority(Permission.MANAGER_READ.name())
         .requestMatchers(HttpMethod.POST,
         "/api/v1/manager/**").hasAuthority(Permission.MANAGER_CREATE.name())
         .requestMatchers(HttpMethod.PUT,
         "/api/v1/manager/**").hasAuthority(Permission.MANAGER_UPDATE.name())
         .requestMatchers(HttpMethod.DELETE,
         "/api/v1/manager/**").hasAuthority(Permission.MANAGER_DELETE.name())
        .anyRequest()
        .authenticated()
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }
}
