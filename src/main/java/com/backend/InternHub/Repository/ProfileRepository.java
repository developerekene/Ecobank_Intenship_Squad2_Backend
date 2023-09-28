package com.backend.InternHub.Repository;

import com.backend.InternHub.Entities.user.ProfileData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends MongoRepository<ProfileData, String> {
    ProfileData findByEmail(String email);
    void deleteByEmail(String email);
}
