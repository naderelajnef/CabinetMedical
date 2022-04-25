package com.cabinet.cabinet.repository;

import com.cabinet.cabinet.domain.RDV;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RDVRepository extends CrudRepository<RDV,Integer>{
    
    
}
