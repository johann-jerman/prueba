package com.spring.auth.controller;

import com.spring.auth.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/auth")

public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    public AuthController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<AuthentucationResponse> register (@RequestBody RegisterReq req) {
        System.out.println(req);

        return ResponseEntity.ok(authService.register(req));
    }

    @PostMapping(value = "/loggin")
    public ResponseEntity<AuthentucationResponse> loggin(@RequestBody AuthentucationReq req){
        System.out.println(req);
        return ResponseEntity.ok(authService.authenticate(req));
    }
    @PostMapping(value = "/logout")
    public String logout(){
        return "Te deslogeaste";
    }
}
