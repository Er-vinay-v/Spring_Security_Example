package com.security.SpringSecurity.controller;

@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping("/security")
public class MainController {

    @org.springframework.beans.factory.annotation.Autowired
    com.security.SpringSecurity.service.UserService userService;

    @org.springframework.web.bind.annotation.GetMapping
    @org.springframework.web.bind.annotation.RequestMapping("/public/data")
    public String getData() {

        return "Hello world ! Inside Home controller";
    }

    @org.springframework.web.bind.annotation.GetMapping
    @org.springframework.web.bind.annotation.RequestMapping("/normal/data")
    public String normalData() {

        return "Hii Inside normalData Method !";
    }

    @org.springframework.web.bind.annotation.GetMapping
    @org.springframework.web.bind.annotation.RequestMapping("/admin/data")
    public String adminData() {

        return "inside adminData Method !";
    }

    @org.springframework.web.bind.annotation.PostMapping
    @org.springframework.web.bind.annotation.RequestMapping("/create/user")
    public boolean createUser(@org.springframework.web.bind.annotation.RequestBody(required = false)com.security.SpringSecurity.model.User user){
        userService.createUser(user);
        return true;
    }
}
