package com.dummy.app;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Intel on 3/20/2016.
 */
public class CustomSecurityConfig implements AuthenticationProvider {

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String password = (String) authentication.getCredentials();

        UserDetails ud = new UserDetails() {
            public Collection<? extends GrantedAuthority> getAuthorities() {
                GrantedAuthority gd = new GrantedAuthority() {
                    public String getAuthority() {
                        return "ROLE_ADMIN";
                    }
                };
                List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
                authList.add(gd);
                return authList;
            }

            public String getPassword() {
                return "ankit";
            }

            public String getUsername() {
                return "Ankit";
            }

            public boolean isAccountNonExpired() {
                return false;
            }

            public boolean isAccountNonLocked() {
                return false;
            }

            public boolean isCredentialsNonExpired() {
                return false;
            }

            public boolean isEnabled() {
                return true;
            }
        };

        if (!password.equals(ud.getPassword())) {
            throw new BadCredentialsException("Wrong password.");
        }


        return new UsernamePasswordAuthenticationToken(ud, "ankit", ud.getAuthorities());
    }

    public boolean supports(Class<?> aClass) {
        return true;
    }
}

