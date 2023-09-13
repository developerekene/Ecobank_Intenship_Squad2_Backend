package com.backend.InternHub.services;

import com.backend.InternHub.Entities.user.UserEntity;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void registerUser(UserEntity user);
    UserEntity getUserByEmail(String Email);
}
