package com.spring.auth.service;

import com.spring.auth.entity.Rol;
import com.spring.auth.entity.User;
import com.spring.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthentucationResponse register(RegisterReq req) {
        var user = User.builder()
                .name(req.getName())
                .email(req.getEmail())
                .password(passwordEncoder.encode(req.getPassword()))
                .rol(Rol.USER)
                .build();
        repository.save(user);

        var jwtToken =  jwtService.generateToken(user);
        return AuthentucationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthentucationResponse authenticate(AuthentucationReq req) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        req.getEmail(),
                        req.getPassword()
                )
        );

        var user = repository.findByEmail(req.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        return AuthentucationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
