package com.spring.auth.interfaces;

import com.spring.auth.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Crud {
    List<User> getAll();
    void  getByPk();
    User create(User user);
    ResponseEntity update(User body);
    ResponseEntity delete(Long id);

}
