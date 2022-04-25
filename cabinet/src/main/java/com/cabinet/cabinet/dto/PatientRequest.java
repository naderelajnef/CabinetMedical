package com.cabinet.cabinet.dto;
import java.util.Date;

import com.cabinet.cabinet.domain.DossierMedical;


public class PatientRequest {
    private int id_patient;
    private String nom;
    private String prenom;
    private Date date_naissance;
    private String telephone;
    private String adresse;
    private String social_account;

   // private int medecin;

   private DossierMedical dossierM;


   public DossierMedical getDossierM() {
       return dossierM;
   }

   public void setDossierM(DossierMedical dossierM) {
       this.dossierM = dossierM;
   }
    public int getId_patient() {
        return id_patient;
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
    public String getTelephone(){
        return telephone;
    }
    public void  setTelephone(String telephone){
            this.telephone=telephone;
    }
    public String getAdresse(){
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getSocialAccount(){
        return social_account;
    }
    public void setSocialAccount(String social_account){
        this.social_account=social_account;
    
    }
    public Date getdateNaissance(){
        return date_naissance;
    }
    public void setdateNaissance(Date date_naissance){
        this.date_naissance=date_naissance;
    }
    
    
}
