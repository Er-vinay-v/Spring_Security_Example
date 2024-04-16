package com.security.SpringSecurity.model;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@jakarta.persistence.Entity
public class User {

    @jakarta.persistence.Id
            @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    int id;
    String name;
    String email;
    String password;
    String isAdmin;


}
