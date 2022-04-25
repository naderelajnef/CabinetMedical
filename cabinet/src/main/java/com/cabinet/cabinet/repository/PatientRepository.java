package com.cabinet.cabinet.repository;




import com.cabinet.cabinet.domain.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient,Integer> {
    
}
