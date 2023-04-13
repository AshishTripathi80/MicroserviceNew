package com.javatechie.controller;

import com.javatechie.entity.UserCredential;
import com.javatechie.repository.UserCredentialRepository;
import com.javatechie.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService service;


    @Autowired
    private UserCredentialRepository userCredentialRepository;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredential user) {
        return service.saveUser(user);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody UserCredential userCredential) {
        UserCredential user = userCredentialRepository.findAllByUsername(userCredential.getUsername());


        if (user.getUsername().equals(userCredential.getUsername()) && user.getPassword().equals(userCredential.getPassword())) {
            return service.generateToken(userCredential.getUsername());
        } else {
            throw new RuntimeException("invalid access");
        }
    }

    @PostMapping("/login")
    public UserCredential login(@RequestBody UserCredential userCredential) {
        UserCredential user = userCredentialRepository.findAllByUsername(userCredential.getUsername());


        if (user.getUsername().equals(userCredential.getUsername()) && user.getPassword().equals(userCredential.getPassword())) {
            String token= service.generateToken(userCredential.getUsername());
            user.setToken(token);
            return user;
        } else {
            throw new RuntimeException("invalid access");
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        service.validateToken(token);
        return "Token is valid";
    }
}
