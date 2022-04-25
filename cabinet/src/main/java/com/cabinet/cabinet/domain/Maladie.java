package com.cabinet.cabinet.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Maladie {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id_maladie;
    private String nom;
    private String diagnostic;
    
    private String traitement;
    private String evolution;

     @ManyToOne
      @JoinColumn(name="id_dossier" )
     private DossierMedical  dossier;

     public DossierMedical getDossier() {
        return dossier;
    }

     public void setDossier(DossierMedical dossier) {
        this.dossier = dossier;
     }


  
    public void setId_maladie(int id_maladie) {
        this.id_maladie = id_maladie;
    }


    public int getId_maladie() {
        return id_maladie;
    }
   
    public String getDiagnostic() {
        return diagnostic;
    }
    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }
    public String getTraitement() {
        return traitement;
    }
    public void setTraitement(String traitement) {
        this.traitement = traitement;
    }
    public String getEvolution() {
        return evolution;
    }
    public void setEvolution(String evolution) {
        this.evolution = evolution;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    

    
}
