package com.dummy.app;

import org.apache.commons.lang.StringUtils;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Intel on 3/26/2016.
 */
public class LdapAuthPopulator implements LdapAuthoritiesPopulator {

    public Collection<? extends GrantedAuthority> getGrantedAuthorities(DirContextOperations dirContextOperations, String s) {

        List<GrantedAuthority> authoritiesList = new ArrayList<GrantedAuthority>();
        GrantedAuthority gaUSER = new GrantedAuthority() {
            public String getAuthority() {
                return "ROLE_USER";
            }
        };

        GrantedAuthority gaAdmin = new GrantedAuthority() {
            public String getAuthority() {
                return "ROLE_ADMIN";
            }
        };
        if(StringUtils.equalsIgnoreCase("ahel@example.com",s)){
            authoritiesList.add(gaUSER);
        }else{
            authoritiesList.add(gaAdmin);
        }

        return authoritiesList;
    }
}
