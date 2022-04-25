package com.cabinet.cabinet.repository;



import com.cabinet.cabinet.domain.Medecin;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MedecinRepository extends CrudRepository<Medecin,Integer> {

}
