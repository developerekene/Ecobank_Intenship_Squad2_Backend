package com.backend.InternHub.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false, unique = true)
    private String username;


    @Getter
    @Setter
    @Column(nullable = false)
    private String password;

}

