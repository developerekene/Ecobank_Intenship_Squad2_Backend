package com.backend.InternHub.request;


import com.backend.InternHub.Entities.user.ProfileData;
import lombok.Data;

@Data
public class EditProfileRequestBody {
    private String token;
    private ProfileData profileData;

    public EditProfileRequestBody(String token, ProfileData profileData, String error){
        this.token = token;
        this.profileData = profileData;
    }

    public EditProfileRequestBody() {

    }
}
