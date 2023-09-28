package com.backend.InternHub.services.impl;

import com.backend.InternHub.Entities.user.ProfileData;
import com.backend.InternHub.Repository.ProfileRepository;
import com.backend.InternHub.services.ProfileUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileUpdateImpl implements ProfileUpdate {

    private final ProfileRepository profileRepository;

     @Autowired
     public ProfileUpdateImpl(ProfileRepository profileRepository){
         this.profileRepository = profileRepository;
     }
    public boolean UserExist(String email){
         ProfileData userData = profileRepository.findByEmail(email);
         if(userData==null){
             return false;
         }
         else return true;
    }
    public void SaveUser(ProfileData profileData){
        profileRepository.save(profileData);
    }
    public ProfileData getProfileData(String email){
        ProfileData user = profileRepository.findByEmail(email);
        return user;
    }
    public ProfileData UpdateProfile(ProfileData userData, ProfileData userProfileData){
        userProfileData.setJobTitle(userData.getJobTitle());
        userProfileData.setAddress(userData.getAddress());
        userProfileData.setSkills(userData.getSkills());
        userProfileData.setAbout(userData.getAbout());
        userProfileData.setEducation(userData.getEducation());
        userProfileData.setExperience(userData.getExperience());
        userProfileData.setYoutube(userData.getYoutube());
        userProfileData.setInstagram(userData.getInstagram());
        userProfileData.setGithub(userData.getGithub());
        userProfileData.setFigma(userData.getFigma());
        profileRepository.deleteById(userProfileData.getId());
        profileRepository.save(userProfileData);
        return userProfileData;
    }
}
