package com.spring.auth.service;


import com.spring.auth.entity.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterReq {
    private String name;
    private String email;
    private String password;
    //private Rol rol;
}
