package com.cabinet.cabinet.controller;

import java.util.Optional;

import com.cabinet.cabinet.domain.DossierMedical;
import com.cabinet.cabinet.repository.DossierMedicalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DossierMedicalController {
    @Autowired
    private DossierMedicalRepository dossierRepository;
    @GetMapping("/app/v1/dossier")
    public @ResponseBody ResponseEntity<Iterable<DossierMedical>> find(){
        Iterable<DossierMedical> dossier = dossierRepository.findAll();
        return ResponseEntity.ok().body(dossier);
    }
    @GetMapping("/api/v1/dossier/{id}")
    public @ResponseBody ResponseEntity<DossierMedical> getid(@PathVariable int id) {
        Optional<DossierMedical> result = dossierRepository.findById(id);
        if (result.isEmpty())
            return ResponseEntity.notFound().build();
        DossierMedical dossier = result.get();
        return ResponseEntity.ok().body(dossier);
    }

}
