package com.maurithiol.LoginSystem.auth;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("spring-security")
@AllArgsConstructor
public class AuthUser {

    @Id
    private String id;
    @Indexed
    private String username;
    private String password;
    private AuthRole role;
    private boolean active;

}