package com.cabinet.cabinet.dto;



public class MedecinRequest {
    private int id_medecin;
  

   

    private String nom;
    private String prenom;
    private String specialite;
    
//private Patient patient;


    public int getId_medecin() {
        return id_medecin;
    }
    public String getNom() {
        return nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
   
    public String getSpecialite() {
        return specialite;
    }
    
}
