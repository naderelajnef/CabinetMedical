package com.cabinet.cabinet.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Medecin {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id_medecin;
    private String nom;
    private String prenom;
    private String specialite;

   // @OneToMany(mappedBy="medecin")
    //private List<Patient> patient;


    //getters et setters
    public int getId_medecin() {
        return id_medecin;
    }
    public void setId_medecin(int id_medecin) {
        this.id_medecin = id_medecin;
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
    public String getSpecialite() {
        return specialite;
    }
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    
}
