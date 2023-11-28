package com.nyoba.nyicilprojek.config;

import org.springframework.beans.factory.annotation.Autowired;

import com.nyoba.nyicilprojek.repository.AuthRepository;
import com.nyoba.nyicilprojek.repository.MemberRepository;

import com.nyoba.nyicilprojek.services.AuthService;
import com.nyoba.nyicilprojek.services.MemberService;

public class AuthConfig {

    @Autowired
    public AuthRepository authRepository;
    @Autowired
    public MemberRepository memberRepository;

    @Autowired
    public AuthService authService;
    @Autowired
    public MemberService memberService;

    public final String ADMIN_USERNAME="admin";
    public final String ADMIN_PASSWORD="admin123";
    public static boolean isAdminLogin=false;
    public static boolean isUserLogin=false;
    public static boolean isLogin=false;
    public static String role="admin";
}