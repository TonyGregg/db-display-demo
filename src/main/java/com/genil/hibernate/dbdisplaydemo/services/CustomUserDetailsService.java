package com.genil.hibernate.dbdisplaydemo.services;

import com.genil.hibernate.dbdisplaydemo.domain.SecretClient;
import com.genil.hibernate.dbdisplaydemo.repos.SecretClientRepository;
import com.genil.hibernate.dbdisplaydemo.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private SecretClientRepository secretClientRepository;

    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        SecretClient secretClient = secretClientRepository.findByEmail(userName)
                .orElseThrow(() -> new UsernameNotFoundException("Email " + userName + " not found"));
        return new org.springframework.security.core.userdetails.User(
                secretClient.getEmail(),
                secretClient.getPassword(),
                getAuthorities(secretClient)
        );
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(SecretClient secretClient) {
        String[] userRoles = secretClient.getRoles()
                .stream()
                .map((role) -> role.getName())
                .toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }
}