package com.security.SpringSecurity.service;

@org.springframework.stereotype.Service
public class UserService {

    @org.springframework.beans.factory.annotation.Autowired
    com.security.SpringSecurity.repository.UserRepository userRepository;

    @org.springframework.beans.factory.annotation.Autowired
    org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;

    public void createUser(com.security.SpringSecurity.model.User user){
       user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
