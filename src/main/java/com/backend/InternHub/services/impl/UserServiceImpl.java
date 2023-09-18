package com.backend.InternHub.services.impl;

import com.backend.InternHub.Entities.user.UserEntity;
import com.backend.InternHub.Repository.UserRepository;
import com.backend.InternHub.exceptions.EtAuthException;
import com.backend.InternHub.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(UserEntity user){
            String email = user.getEmail();
            //checks if user email already exists, if yes throws exception, else saves the user in the table
            UserEntity singleUser = getUserByEmail(email);
            if(singleUser!=null) {
                System.out.println("Email already in use");
                throw new EtAuthException("Email already in use");
            }
            else {
                userRepository.save(user);
            }
    }
    @Override
    public UserEntity getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
