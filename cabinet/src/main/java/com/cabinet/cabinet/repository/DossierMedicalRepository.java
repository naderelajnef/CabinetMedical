package com.cabinet.cabinet.repository;

import com.cabinet.cabinet.domain.DossierMedical;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DossierMedicalRepository  extends CrudRepository<DossierMedical,Integer> {
    
}
