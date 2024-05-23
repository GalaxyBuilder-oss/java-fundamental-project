package com.salim.systempub.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.salim.systempub.entities.Auth;
import com.salim.systempub.repositories.AuthRepository;

@Service
public class CostumUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Auth auth = authRepository.findByUsername(username).orElse(null);
        if(auth == null) {
            throw new UnsupportedOperationException("User Not Found");
        }
        return new CostumUserDetails(auth);
    }
    
}
