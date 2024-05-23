package com.salim.systempub.dto;

import lombok.Data;

@Data
public class AuthRequestDto {

    private String username;
    
    private String Password;

    private String role;
    
    private String idMember;
}
