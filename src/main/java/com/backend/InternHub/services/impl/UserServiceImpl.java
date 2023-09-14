package com.backend.InternHub.services.impl;

import com.backend.InternHub.Entities.user.UserEntity;
import com.backend.InternHub.Repositories.UserRepository;
import com.backend.InternHub.exceptions.EtAuthException;
import com.backend.InternHub.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

import static java.awt.SystemColor.info;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(UserEntity user){

            Pattern pattern = Pattern.compile("^(.+)@(.+)$");
            String email = user.getEmail();
            //checks if email is not null
            if(email!=null){
                email = email.toLowerCase();
            }
            //checks if email matches pattern
            if(!pattern.matcher(email).matches()){
                throw new EtAuthException("invalid email");
            }
            //checks if user email already exists, if yes throws exception, else saves the user in the table
            UserEntity singleUser = getUserByEmail(email);
            if(singleUser!=null) {
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
