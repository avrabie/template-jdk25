package com.execodex.demo25.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;

@Configuration
@EnableWebFluxSecurity
public class SecConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
//                .csrf(csrfSpec -> {
//                    csrfSpec.requireCsrfProtectionMatcher(
//                            ServerWebExchangeMatchers.pathMatchers(HttpMethod.POST, "/public")
//                    );
//                })
                .authorizeExchange((authorize) -> authorize
                        .pathMatchers("/public").permitAll()
                        .pathMatchers(HttpMethod.POST,"/public").permitAll()
                        .pathMatchers(HttpMethod.GET,"/hello").hasAnyRole("ADMIN")
                        .anyExchange().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
//                .oauth2Client(Customizer.withDefaults())
                .oauth2Login(Customizer.withDefaults())
//                .httpBasic(withDefaults())
                .formLogin(Customizer.withDefaults())  // we need an authentication manager for this
        ;
        return http.build();
    }

    @Bean
    public MapReactiveUserDetailsService userDetailsService() {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("USER", "ADMIN")
                .build();
        return new MapReactiveUserDetailsService(user,admin);
    }


}
