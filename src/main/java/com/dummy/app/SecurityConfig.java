package com.dummy.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Intel on 3/19/2016.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.exceptionHandling().accessDeniedPage("/AccessDenied")
                .and()
                .authorizeRequests()
                .regexMatchers("/student").hasAnyRole("ADMIN")
                .regexMatchers("student.+").hasAnyRole("USER").and()
                .formLogin()
                .and().sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(true);
    }

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(new CustomSecurityConfig());
        /*auth.inMemoryAuthentication().withUser("Ankit").password("ankit").roles("USER")
                .and().withUser("admin").password("admin").roles("ADMIN");*/

        // Ldap Configuration
        auth.ldapAuthentication().ldapAuthoritiesPopulator(new LdapAuthPopulator()).userSearchBase("ou=People").userSearchFilter("(mail={0})").
                groupSearchBase("ou=Groups").groupSearchFilter("member={0}").contextSource().root("dc=example,dc=com").ldif("classpath:Example.ldif");


    }

}
