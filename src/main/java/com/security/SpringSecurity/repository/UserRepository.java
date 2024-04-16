package com.security.SpringSecurity.repository;

@org.springframework.stereotype.Repository
public interface UserRepository extends org.springframework.data.jpa.repository.JpaRepository<com.security.SpringSecurity.model.User,Integer> {

    public com.security.SpringSecurity.model.User findByEmail(String email);


}
