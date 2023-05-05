package com.javatechie.controller;

import com.javatechie.entity.UserCredential;
import com.javatechie.repository.UserCredentialRepository;
import com.javatechie.service.AuthService;
import com.javatechie.utility.GlobalResources;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {


    private Logger logger= GlobalResources.getLogger(AuthController.class);
    @Autowired
    private AuthService service;


    @Autowired
    private UserCredentialRepository userCredentialRepository;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredential user) {
        logger.info("Received a request to register a new user: {}", user.getUsername());
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
            logger.debug("Token generated for user {}: {}", userCredential.getUsername(), token);
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


    @PostMapping("/logout")
    public void removeToken(@RequestBody UserCredential userCredential) {
        UserCredential user = userCredentialRepository.findAllByUsername(userCredential.getUsername());

        if (user.getUsername().equals(userCredential.getUsername()) && user.getPassword().equals(userCredential.getPassword())) {
            user.setToken(null);
            userCredentialRepository.save(user);
        } else {
            throw new RuntimeException("invalid access");
        }
    }





    @PostMapping("/generate")
    public ResponseEntity<String> generateUser() {
        service.generateAndSaveUser();
        return ResponseEntity.ok("3 user generated and saved.");
    }


    @PostConstruct
    public void init() {
        generateUser();
    }
}
