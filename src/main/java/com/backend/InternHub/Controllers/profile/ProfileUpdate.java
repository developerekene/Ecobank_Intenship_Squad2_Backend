package com.backend.InternHub.Controllers.profile;


import com.backend.InternHub.Entities.user.ProfileData;
import com.backend.InternHub.Jwt.JwtUtil;
import com.backend.InternHub.Repository.ProfileRepository;
import com.backend.InternHub.exceptions.EtAuthException;
import com.backend.InternHub.responses.AuthResponse;
import com.backend.InternHub.responses.Response;
import com.backend.InternHub.services.impl.ProfileUpdateImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users/profile")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ProfileUpdate {

    private final ProfileRepository profileRepository;
    private ProfileUpdateImpl profileUpdate;
    private final JwtUtil jwtUtil;

    @Autowired
    public ProfileUpdate(ProfileRepository profileRepository, ProfileUpdateImpl profileUpdate, JwtUtil jwtUtil){
        this.profileRepository=profileRepository;
        this.profileUpdate = profileUpdate;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/update")
    public ResponseEntity<AuthResponse> EditProfile(@RequestBody ProfileData userData){
        try{
            ProfileData userProfileData = profileRepository.findByEmail(userData.getEmail());
            ProfileData profileDataUpdated = profileUpdate.UpdateProfile(userData,userProfileData);
            return ResponseEntity.ok(new AuthResponse(profileDataUpdated));
        }catch (EtAuthException ex) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new AuthResponse(ex.getMessage()));
        }
    }
}

