package com.spring.auth.helper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Crypto {

    public static String hashPass(String pass){
        BCryptPasswordEncoder hashPass = new BCryptPasswordEncoder();
        return hashPass.encode(pass);
    }

    public static Boolean comparePass(String pass, String encodePass){
        BCryptPasswordEncoder hashPass = new BCryptPasswordEncoder();
        return hashPass.matches(pass, encodePass);
    }
}
