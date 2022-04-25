package com.cabinet.cabinet.controller;

import java.util.Optional;

import com.cabinet.cabinet.domain.Maladie;
import com.cabinet.cabinet.dto.MaladieRequest;
import com.cabinet.cabinet.repository.MaladieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin("*")
public class MaladieController {
    @Autowired
    private MaladieRepository maladieRepository;
    @GetMapping("/app/v1/maladie")
    public @ResponseBody ResponseEntity<Iterable<Maladie>> find(){
        Iterable<Maladie> maladie = maladieRepository.findAll();
        return ResponseEntity.ok().body(maladie);
    }
    @GetMapping("/app/v1/maladie/{id}")
    public @ResponseBody ResponseEntity<Maladie> getid(@PathVariable int id) {
        Optional<Maladie> result = maladieRepository.findById(id);
        if (result.isEmpty())
            return ResponseEntity.notFound().build();
        Maladie maladie = result.get();
        return ResponseEntity.ok().body(maladie);
    }


    @PostMapping("/app/v1/maladie")
    public @ResponseBody ResponseEntity<Maladie>create( @RequestBody MaladieRequest requestDTO){
        Maladie M =new Maladie();
        M.setNom(requestDTO.getNom());
        M.setDiagnostic(requestDTO.getDiagnostic());
        M.setTraitement(requestDTO.getTraitement());
        M.setEvolution(requestDTO.getEvolution());
        M.setDossier(requestDTO.getDossier());
        maladieRepository.save(M);
        return ResponseEntity.ok().body((M)); 
    }
    
}
