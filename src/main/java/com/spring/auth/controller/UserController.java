package com.spring.auth.controller;

import com.spring.auth.entity.User;
import com.spring.auth.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user/")
public class UserController {
// update delete

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public List<User> getAll(){
        System.out.println(userService);
        return userService.getAll();
    }

    @GetMapping(value = "/{id}")
    public void getById (@PathVariable Long id){

    }

    @PutMapping(value = "/update")
    public ResponseEntity update (@RequestBody User body){
            return userService.update(body);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id){
           return userService.delete(id);
    }
}
