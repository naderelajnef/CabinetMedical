package com.cabinet.cabinet.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id_role;
    private String nomRole;




    public int getId_role() {
        return id_role;
    }

    public String getNomRole() {
        return nomRole;
    }
    public void setNomRole(String nomRole) {
        this.nomRole = nomRole;
    }
    
}
