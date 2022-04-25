package com.cabinet.cabinet.dto;

import com.cabinet.cabinet.domain.DossierMedical;

public class MaladieRequest {
    private int id_maladie;
   
    private String nom;
    private String diagnostic;
    private String traitement;
    private String evolution;
    private DossierMedical  dossier;

     public DossierMedical getDossier() {
        return dossier;
    }

     public void setDossier(DossierMedical dossier) {
        this.dossier = dossier;
     }

    public int getId_maladie() {
        return id_maladie;
    }
  
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
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
    
}
