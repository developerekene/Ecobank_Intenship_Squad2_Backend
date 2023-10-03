package com.backend.InternHub.Controllers.Login;


import com.backend.InternHub.Entities.user.ProfileData;
import com.backend.InternHub.Entities.user.UserEntity;
import com.backend.InternHub.Jwt.JwtUtil;
import com.backend.InternHub.Repository.ProfileRepository;
import com.backend.InternHub.Repository.UserRepository;
import com.backend.InternHub.responses.AuthResponse;
import com.backend.InternHub.services.impl.ProfileUpdateImpl;
import com.backend.InternHub.services.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class UserLoginController {

    private final UserRepository userRepository;

    private final ProfileUpdateImpl profileUpdate;

    private final JwtUtil jwtUtil;


    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");
        System.out.println(loginRequest);
        UserEntity user = userRepository.findByEmail(email);
        log.info("password from front:: {}", password);
        String firstname = user.getFirstname();
        String lastname = user.getLastname();
        String fullname = firstname+" "+lastname;
        if (user == null) {
            AuthResponse authResponse = new AuthResponse();
            authResponse.setMessage("Email or Password is invalid");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(authResponse);
        }
        log.info("password from DB:: {}", user.getPassword());

        boolean passwordCheck = new BCryptPasswordEncoder().matches(password, user.getPassword());


        AuthResponse authResponse = new AuthResponse();
        if (passwordCheck) {
            boolean userExists = profileUpdate.UserExist(email);

                String token = jwtUtil.generateToken(email);
                authResponse.setToken(token);
            if (!userExists){
                ProfileData profileData = new ProfileData();
                profileData.setFullname(fullname);
                profileData.setEmail(email);
                authResponse.setProfileData(profileData);
                profileUpdate.SaveUser(profileData);
            }
            else {
                ProfileData profile = profileUpdate.getProfileData(email);
                authResponse.setProfileData(profile);
                authResponse.setConsoleMessage("already saved profile Data");
            }
            return ResponseEntity.ok(authResponse);
        } else {
            authResponse.setMessage("Incorrect password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(authResponse);

        }
    }
}
