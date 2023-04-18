package com.javatechie.repository;

import com.javatechie.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialRepository  extends JpaRepository<UserCredential,Integer> {
    UserCredential findAllByUsername(String username);
}
