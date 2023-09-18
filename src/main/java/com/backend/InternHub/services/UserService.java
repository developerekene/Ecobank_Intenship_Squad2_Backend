package com.backend.InternHub.services;

import com.backend.InternHub.Entities.user.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void registerUser(UserEntity user);
    UserEntity getUserByEmail(String Email);
}
