package com.backend.InternHub.Controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {
    @PostMapping("/login")
    public ResponseEntity<String>  login(@RequestBody LoginRequest loginRequest){
        String username= LoginRequest.getUsername();
        String password =LoginRequest.getPassword();
        User user = userService.findByUsername(username);

        if (user == null) {
            return ResponseEntity.badRequest().body("User not found");
        }

        if (password.equals(user.getPassword())) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.badRequest().body("Incorrect password");
        }
    }
}






        }

}
