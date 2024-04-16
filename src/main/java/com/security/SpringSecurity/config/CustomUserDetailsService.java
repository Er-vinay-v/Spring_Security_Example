package com.security.SpringSecurity.config;

public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @org.springframework.beans.factory.annotation.Autowired
    com.security.SpringSecurity.repository.UserRepository userRepository;
    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws org.springframework.security.core.userdetails.UsernameNotFoundException {

        com.security.SpringSecurity.model.User user=userRepository.findByEmail(username);
        if(user==null){
            throw new org.springframework.security.core.userdetails.UsernameNotFoundException("User Not Found");
        }
        String roles="true".equalsIgnoreCase(user.getIsAdmin())?"ADMIN":"NORMAL";
        org.springframework.security.core.userdetails.UserDetails userDetails= org.springframework.security.core.userdetails.
                User.builder().username(user.getEmail()).password(user.getPassword()).roles(roles).build();
        return userDetails;
    }
}
