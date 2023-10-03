package com.backend.InternHub.services;

import com.backend.InternHub.Entities.user.ProfileData;

public interface ProfileUpdate {
    void SaveUser(ProfileData userData);
    ProfileData UpdateProfile(ProfileData userData, ProfileData userProfileData);
    ProfileData getProfileData(String email);
    boolean UserExist(String fullname);
}
