package com.spring.auth.controller;

import com.spring.auth.entity.User;
import com.spring.auth.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register")
    public User register (@RequestBody User body) {
        return userService.create(body);
    }

    @PostMapping(value = "/loggin")
    public void loggin(@RequestBody User body){

    }
    @PostMapping(value = "/logout")
    public void logout(){

    }
}
