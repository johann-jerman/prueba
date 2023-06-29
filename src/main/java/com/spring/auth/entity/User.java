package com.spring.auth.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@ToString
public class User {

    @Getter @Setter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private String password;

    public User() {}

    public User(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
