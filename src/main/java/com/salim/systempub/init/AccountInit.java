package com.salim.systempub.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.salim.systempub.constant.RolesConstant;
import com.salim.systempub.entities.Auth;
import com.salim.systempub.repositories.AuthRepository;

public class AccountInit implements Runnable {

    @Autowired
    private AuthRepository authRepository;

    @Override
    public void run() {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Auth auth = new Auth(1L, "admin", "123", RolesConstant.ADMIN, null);
        auth.setPassword(passwordEncoder.encode(auth.getPassword()));
        if (authRepository.findAll().isEmpty())
            authRepository.save(auth);
    }
}
