package com.cabinet.cabinet.controller;

import java.util.Optional;

import com.cabinet.cabinet.domain.User;
import com.cabinet.cabinet.repository.UserRepository;
import com.cabinet.cabinet.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins= "*")
public class UserController {

    @Autowired
    UserRepository userRep;
    @RequestMapping(value="/login/{username}",method= RequestMethod.GET)
    public Optional<User> getUserByUsername(  @PathVariable("username") String username){
        return userRep.findByUsername(username);
    }

   
    @Autowired 
    UserService service;
    @PostMapping(value="/registeruser")
    public User  registerUser(@RequestBody User user) throws Exception{
        String tempEmail = user.getEmail();
        if(tempEmail!=null && !"".equals(tempEmail)){
           User userObj =  service.fetchUserByEmail(tempEmail);
            if(userObj != null){
                throw new Exception ("user with " +tempEmail+ "is already existe");
            }
        
        }
        User userObj =null;
        userObj=service.saveUser(user);
        return userObj;

    }
   

    @PostMapping(value="/login")
    public User loginUser(@RequestBody User user) throws Exception{
        String tempEmail= user.getEmail();
        String temPass = user.getPassword();

        User userObj = null;
        if(tempEmail != null && temPass != null){
           userObj =  service.fetchUserByEmailAndPassword(tempEmail, temPass);
        }
        if(userObj ==null){
            throw new Exception("bad request");
        }
        return userObj ;

    }

}
