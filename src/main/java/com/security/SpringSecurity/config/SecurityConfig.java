package com.security.SpringSecurity.config;

@org.springframework.context.annotation.Configuration
@org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
public class SecurityConfig {

  /*  @org.springframework.context.annotation.Bean
    public org.springframework.security.core.userdetails.UserDetailsService userDetailsService() {
        org.springframework.security.core.userdetails.UserDetails admin = org.springframework.security.core.userdetails.User.builder().
                username("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN").build();
        org.springframework.security.core.userdetails.UserDetails normal=
                org.springframework.security.core.userdetails.User.builder().username("vinay").password( passwordEncoder().encode("1234")).roles("NORMAL").build();
        return new org.springframework.security.provisioning.InMemoryUserDetailsManager(admin,normal);
    }
*/
//    @org.springframework.context.annotation.Bean
//    public org.springframework.security.web.SecurityFilterChain securityFilterChain(org.springframework.security.config.annotation.web.builders.HttpSecurity httpSecurity)
//            throws Exception {
//
//        return httpSecurity.authorizeHttpRequests(auth -> {
//            auth.requestMatchers("/security/public/**").permitAll();
//            auth.requestMatchers("/security/normal/**").hasRole("NORMAL");
//            auth.requestMatchers("/security/admin/**").hasRole("ADMIN");
//
//            auth.anyRequest().authenticated();
//        }).formLogin(org.springframework.security.config.Customizer.withDefaults()).build();
//    }

    @org.springframework.context.annotation.Bean
    public org.springframework.security.core.userdetails.UserDetailsService userDetailsService(){
        return new com.security.SpringSecurity.config.CustomUserDetailsService();
    }

    //when you want to log in from db data
    @org.springframework.context.annotation.Bean
    public org.springframework.security.web.SecurityFilterChain securityFilterChain(org.springframework.security.config.annotation.web.builders.HttpSecurity httpSecurity)
            throws Exception {
        return httpSecurity.csrf(csrf->{
            csrf.disable();
        }).authorizeHttpRequests(auth -> {
            auth.requestMatchers("/security/public/**").permitAll();
            auth.requestMatchers("/security/normal/**").hasRole("NORMAL");
            auth.requestMatchers("/security/admin/**").hasRole("ADMIN");
            auth.anyRequest().permitAll();
        }).formLogin(org.springframework.security.config.Customizer.withDefaults()).build();
    }

    @org.springframework.context.annotation.Bean
    public org.springframework.security.crypto.password.PasswordEncoder passwordEncoder(){
        return new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
    }
}
