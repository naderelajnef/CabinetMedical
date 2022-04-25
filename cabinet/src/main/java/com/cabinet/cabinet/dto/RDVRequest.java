package com.cabinet.cabinet.dto;

import java.sql.Date;



public class RDVRequest {
    private int id_rdv;
   


    private Date date;
   
    
   
    private String heure;

    
    public int getId_rdv() {
        return id_rdv;
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
