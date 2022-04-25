package com.cabinet.cabinet.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="dossier_medical")
public class DossierMedical {

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id_dossier;

    @OneToOne(mappedBy ="dossierM")
    private Patient patient;



    public int getId_dossier() {
        return id_dossier;
    }

    public void setId_dossier(int id_dossier) {
        this.id_dossier = id_dossier;
    }
 
}
