package com.codeup.springblog.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserWithRoles extends User implements UserDetails {

    public UserWithRoles(User copy){
        super(copy);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roles = "";
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);

    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

//    if you want to exipre credentials after no activity for a certain amount of time
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
