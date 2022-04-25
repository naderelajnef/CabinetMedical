package com.cabinet.cabinet.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="patient")
public class Patient {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
        private int id_patient;
        private String nom;
        private String prenom;
        private Date date_naissance;
        private String telephone;
        private String adresse;
        private String social_account;

 @ManyToMany
 @JoinTable(
     name="rdv_Patients",
     joinColumns = @JoinColumn(name="id_patient"),
     inverseJoinColumns = @JoinColumn(name="id_rdv")
 )
//private List<RDV> rdvpatientsList= new ArrayList<>();
private Collection<RDV> rdvpatientsList;


    @OneToOne
    @JoinColumn(name="dossier_id",referencedColumnName="id_dossier")
    private DossierMedical dossierM;


    public DossierMedical getDossierM() {
        return dossierM;
    }

    public void setDossierM(DossierMedical dossierM) {
        this.dossierM = dossierM;
    }

public int getId() {
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
public Date getdateNaissance(){
    return date_naissance;
}
public void setdateNaissance(Date date_naissance){
    this.date_naissance=date_naissance;
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





    
}
