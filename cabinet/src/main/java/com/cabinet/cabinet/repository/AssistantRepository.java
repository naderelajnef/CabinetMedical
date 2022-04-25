package com.cabinet.cabinet.repository;

import com.cabinet.cabinet.domain.Assistant;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AssistantRepository extends CrudRepository<Assistant,Integer>{
    
}
