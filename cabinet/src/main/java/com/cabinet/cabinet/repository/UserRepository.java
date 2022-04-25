package com.cabinet.cabinet.repository;

import java.util.Optional;

import com.cabinet.cabinet.domain.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository  extends CrudRepository<User,Integer> {
   
    Optional<User> findByUsername(String username);
    public User findByEmail(String email);
    public User findByEmailAndPassword(String email , String password);
}
