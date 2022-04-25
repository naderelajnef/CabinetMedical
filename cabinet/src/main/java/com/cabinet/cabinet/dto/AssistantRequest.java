package com.cabinet.cabinet.dto;

public class AssistantRequest {
    private int id;
    public int getId() {
        return id;
    }
 
    private String nom;
    private String prenom;
 
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
    
}
