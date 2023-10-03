package com.backend.InternHub.Entities.user;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("profileData")
@RequiredArgsConstructor
public class ProfileData {
    @Id
    private String id;
    private String email;
    private String fullname;
    private String jobTitle;
    private String address;
    private List<String> skills;
    private String about;
    private String education;
    private String experience;
    private String youtube;
    private String instagram;
    private String github;
    private String figma;
}
