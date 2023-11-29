package com.nyoba.nyicilprojek.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nyoba.nyicilprojek.models.Auth;
import com.nyoba.nyicilprojek.repository.AuthRepository;

@Service
public class CostumUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Auth auth = authRepository.findByUsername(username);
        if(auth == null) {
            throw new UnsupportedOperationException("User Not Found");
        }
        return new CostumUserDetails(auth);
    }
    
}