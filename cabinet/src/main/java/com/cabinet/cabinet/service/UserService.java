package com.cabinet.cabinet.service;

import com.cabinet.cabinet.domain.User;
import com.cabinet.cabinet.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public User saveUser(User user ){
        return repo.save(user);
        
    }
    public User fetchUserByEmail(String email){
        return repo.findByEmail( email);
    }
    public User fetchUserByEmailAndPassword(String email , String password){
        return repo.findByEmailAndPassword( email,password);
    }

}
