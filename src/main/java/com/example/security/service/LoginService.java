package com.example.security.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList<>();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if ("admin".equals(s)) {
            authorities.add(new SimpleGrantedAuthority(("ROLE_ADMIN")));
            return new User(s, passwordEncoder.encode("1111"), authorities);
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_ANYONE"));
            return new User(s, "", false, false, false, false, authorities);
        }
    }
}
