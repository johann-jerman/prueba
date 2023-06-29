package com.spring.auth.service;

import com.spring.auth.entity.User;
import com.spring.auth.helper.Crypto;
import com.spring.auth.interfaces.Crud;
import com.spring.auth.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements Crud {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void getByPk() {}

    @Override
    public User create(User user) {
        user.setPassword(
            Crypto.hashPass(user.getPassword())
        );
        return userRepository.save(user);
    }

    @Override
    public ResponseEntity update(User body) {
        Optional<User> user = userRepository.findById(body.getId());
        if (user.isPresent()){
            User userToUpdate = user.get();
            if (body.getEmail() != null)
                userToUpdate.setEmail(body.getEmail());
            if (body.getName() != null)
                userToUpdate.setName(body.getName());
            if (body.getPassword() != null)
                userToUpdate.setPassword(Crypto.hashPass(body.getPassword()));

            User userUpdated = userRepository.save(userToUpdate);
            return ResponseEntity.ok(userUpdated);
        }

        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity delete(Long id) {
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return ResponseEntity.ok("useruario eliminado");
        }
        return ResponseEntity.notFound().build();
    }
}
