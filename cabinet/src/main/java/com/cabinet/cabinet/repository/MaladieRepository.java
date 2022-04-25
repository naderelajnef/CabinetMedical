package com.cabinet.cabinet.repository;

import com.cabinet.cabinet.domain.Maladie;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MaladieRepository extends CrudRepository<Maladie,Integer>{
    
}
