package com.backend.InternHub.responses;

import com.backend.InternHub.Entities.user.ProfileData;
import lombok.Data;

@Data
public class AuthResponse {
    private String token;
    private ProfileData profileData;
    private String message;

    public AuthResponse(String token, ProfileData profileData, String error){
        this.token = token;
        this.profileData = profileData;
        this.message = error;
    }

    public AuthResponse() {

    }
}
