package com.cabinet.cabinet.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Assistant {
    private int id_assistant;
    private String nom;
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    public int getId_assistant() {
        return id_assistant;
    }
    public void setId_assistant(int id_assistant) {
        this.id_assistant = id_assistant;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    private String prenom;
    
    
}
