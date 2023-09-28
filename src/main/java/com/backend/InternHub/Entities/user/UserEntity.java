package com.backend.InternHub.Entities.user;



import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("usertable")
@RequiredArgsConstructor
public class UserEntity {
    @Id
    private String userId;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

}
