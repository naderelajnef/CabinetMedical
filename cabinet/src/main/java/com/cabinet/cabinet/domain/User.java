package com.cabinet.cabinet.domain;

import java.util.Collection;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id_user;
    private String username;
    private String email;
    private String password;

    @ManyToMany(cascade=CascadeType.ALL , fetch=FetchType.EAGER)
    @JoinTable(name="user_role",joinColumns=@JoinColumn(name="id_user"),
    inverseJoinColumns =@JoinColumn(name="id_role"))
   
    private Collection <Role> roles;

    public int getId_user() {
        return id_user;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
