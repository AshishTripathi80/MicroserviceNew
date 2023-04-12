package com.javatechie.controller;

import com.javatechie.dto.AuthRequest;
import com.javatechie.entity.UserCredential;
import com.javatechie.repository.UserCredentialRepository;
import com.javatechie.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService service;


    @Autowired
    private UserCredentialRepository userCredentialRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredential user) {
        return service.saveUser(user);
    }

    /*@PostMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return service.generateToken(authRequest.getUsername());
        } else {
            throw new RuntimeException("invalid access");
        }
    }*/

    @PostMapping("/token")
    public String getToken(@RequestBody UserCredential userCredential) {
        //Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        Optional<UserCredential> userOptional = userCredentialRepository.findByName(userCredential.getName());
        UserCredential user = userOptional.get();

        if (user.getName().equals(userCredential.getName()) && user.getPassword().equals(userCredential.getPassword())) {
            return service.generateToken(userCredential.getName());
        } else {
            throw new RuntimeException("invalid access");
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody UserCredential userCredential) {
        //Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        Optional<UserCredential> userOptional = userCredentialRepository.findByName(userCredential.getName());
        UserCredential user = userOptional.get();

        if (user.getName().equals(userCredential.getName()) && user.getPassword().equals(userCredential.getPassword())) {
            return service.generateToken(userCredential.getName());
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
