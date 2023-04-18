package com.javatechie.service;

import com.javatechie.entity.UserCredential;
import com.javatechie.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {

    @Autowired
    private UserCredentialRepository repository;

    @Autowired
    private JwtService jwtService;

    public String saveUser(UserCredential credential) {
        repository.save(credential);
        return "user added to the system";
    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }


    public void generateAndSaveUser() {
        List<UserCredential> userCredentials=new ArrayList<>();
        userCredentials.add(new UserCredential(1,"ashish","ashish",null));
        userCredentials.add(new UserCredential(2,"abc","abc",null));
        userCredentials.add(new UserCredential(3,"123","123",null));
        repository.saveAll(userCredentials);

    }


}
