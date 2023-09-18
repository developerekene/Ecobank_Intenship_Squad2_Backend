package com.backend.InternHub.Entities.user;



import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@Data
@Table(name = "usertable")
@RequiredArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private String email;
    @Column
    private String password;
}
