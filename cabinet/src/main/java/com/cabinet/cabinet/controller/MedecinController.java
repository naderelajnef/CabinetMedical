package com.cabinet.cabinet.controller;

import java.util.Optional;

import com.cabinet.cabinet.domain.Medecin;
import com.cabinet.cabinet.dto.MedecinRequest;
import com.cabinet.cabinet.repository.MedecinRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class MedecinController {
    @Autowired
    private MedecinRepository medecinRepository;
    @GetMapping("/app/v1/medecins")
    public @ResponseBody ResponseEntity<Iterable<Medecin>> find(){
        Iterable<Medecin> medecin = medecinRepository.findAll();
        return ResponseEntity.ok().body(medecin);
    }

    @PostMapping("/app/v1/medecin")
    public @ResponseBody ResponseEntity<Medecin>createmedecin( @RequestBody MedecinRequest requestDTO){
        Medecin M =new Medecin();
        M.setNom(requestDTO.getNom());
        M.setPrenom(requestDTO.getPrenom());
        M.setSpecialite(requestDTO.getSpecialite());
        medecinRepository.save(M);
        return ResponseEntity.ok().body((M)); 
    }
    @PutMapping("/app/v1/medecin/{id}")
    public @ResponseBody ResponseEntity<Medecin> modifyMedecin(@PathVariable int id,
            @RequestBody MedecinRequest requestDTO) {
        Optional<Medecin> result = medecinRepository.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Medecin M = result.get();
        M.setNom(requestDTO.getNom());
        M.setPrenom(requestDTO.getPrenom());
        M.setSpecialite(requestDTO.getSpecialite());
        medecinRepository.save(M);
        return ResponseEntity.ok().body((M));
    }
}
