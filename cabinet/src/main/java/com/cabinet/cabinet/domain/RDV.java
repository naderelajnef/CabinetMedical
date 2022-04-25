package com.cabinet.cabinet.domain;

import java.sql.Date;

import java.util.Collection;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;

import javax.persistence.Table;



@Entity
@Table(name="rdv")
public class RDV {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id_rdv;
    private Date date;
    private String heure;


    
    @ManyToMany(mappedBy = "rdvpatientsList")
       // private List<Patient> patients = new ArrayList<>();
        private Collection<Patient> patients;
    
    // public List<Patient> getPatients() {
    //     return patients;
    // }


    // public void setPatients(List<Patient> patients) {
    //     this.patients = patients;
    // }


    // public void addPatient(Patient patient){
    //     patients.add(patient);
    // }
    

    public Collection<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Collection<Patient> patients) {
        this.patients = patients;
    }

    public int getId_rdv() {
        return id_rdv;
    }
  
    public void setId_rdv(int id_rdv) {
        this.id_rdv = id_rdv;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getHeure() {
        return heure;
    }
    public void setHeure(String heure) {
        this.heure = heure;
    }
    
    

    
}
