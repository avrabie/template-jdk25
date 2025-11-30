package com.execodex.demo25.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcReactiveOAuth2UserService;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.userinfo.ReactiveOAuth2UserService;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.Set;

@Component
public class CustomOidcUserService implements ReactiveOAuth2UserService<OidcUserRequest, OidcUser> {

    private final ReactiveOAuth2UserService<OidcUserRequest, OidcUser> delegate =
            new OidcReactiveOAuth2UserService();

    @Override
    public Mono<OidcUser> loadUser(OidcUserRequest userRequest) {
        return delegate.loadUser(userRequest)
                .map(oidcUser -> {
                    Set<GrantedAuthority> mappedAuthorities = new HashSet<>(oidcUser.getAuthorities());

                    // Example rule-based assignment:
                    String email = oidcUser.getEmail();
//                    if (email.endsWith("@yourcompany.com")) {
                        mappedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//                    } else {
                        mappedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//                    }

                    return new DefaultOidcUser(
                            mappedAuthorities,
                            oidcUser.getIdToken(),
                            oidcUser.getUserInfo()
                    );
                });
    }
}

