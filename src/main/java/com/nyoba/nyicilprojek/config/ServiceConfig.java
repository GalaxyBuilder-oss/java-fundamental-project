package com.nyoba.nyicilprojek.config;

import org.springframework.beans.factory.annotation.Autowired;

import com.nyoba.nyicilprojek.repository.AuthRepository;
import com.nyoba.nyicilprojek.repository.GenerationRepository;
import com.nyoba.nyicilprojek.repository.MemberPaggingRepository;
import com.nyoba.nyicilprojek.repository.MemberRepository;

public class ServiceConfig {
    @Autowired
    public AuthRepository authRepository;
    @Autowired
    public MemberRepository memberRepository;
    @Autowired
    public GenerationRepository generationRepository;
    @Autowired
    public MemberPaggingRepository memberPaggingRepository;
}