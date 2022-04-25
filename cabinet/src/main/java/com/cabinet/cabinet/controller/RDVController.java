package com.cabinet.cabinet.controller;

import java.util.Optional;

import com.cabinet.cabinet.domain.Patient;
import com.cabinet.cabinet.domain.RDV;
import com.cabinet.cabinet.dto.RDVPatientRequest;
import com.cabinet.cabinet.dto.RDVRequest;
import com.cabinet.cabinet.repository.PatientRepository;
import com.cabinet.cabinet.repository.RDVRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class RDVController {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private RDVRepository RDVRepository;

    @GetMapping("/app/v1/rendez-vous")
    public @ResponseBody ResponseEntity<Iterable<RDV>> find(){
        Iterable<RDV>  RDV = RDVRepository.findAll();
        return ResponseEntity.ok().body(RDV);
    }

    @GetMapping("/app/v1/rendez-vous/{id}")
    public @ResponseBody ResponseEntity<RDV> getid( @PathVariable int id) {
        Optional<RDV> result = RDVRepository.findById(id);
        if (result.isEmpty())
            return ResponseEntity.notFound().build();
        RDV RDV = result.get();
        return ResponseEntity.ok().body(RDV);
    }
    @PostMapping("/app/v1/rendez-vous")
    public @ResponseBody ResponseEntity<RDV> create( @RequestBody RDVRequest requestDTO){
        RDV rdv =new RDV();
        rdv.setDate(requestDTO.getDate());
        rdv.setHeure(requestDTO.getHeure());
        RDVRepository.save(rdv);
        return ResponseEntity.ok().body(rdv);
    }
    @PutMapping("/app/v1/rendez-vous/{id}")
    public @ResponseBody ResponseEntity<RDV> modifyRDV(@PathVariable int id,
            @RequestBody RDVRequest requestDTO) {
        Optional<RDV> result = RDVRepository.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        RDV rdv = result.get();
        rdv.setDate(requestDTO.getDate());
        rdv.setHeure(requestDTO.getHeure());
        RDVRepository.save(rdv);
        return ResponseEntity.ok().body((rdv));
    }
    //supprimer un patient::
    @CrossOrigin
    @DeleteMapping("/app/v1/rendez-vous/{id}")
    public @ResponseBody ResponseEntity<RDV> delete( @PathVariable  int id) {
        Optional<RDV> result = RDVRepository.findById(id);
        if (result.isEmpty())
            return ResponseEntity.notFound().build();
            RDVRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

      /*
     * ================================================================================
     * GESTION DES rdv  par patients 
     */

    @PostMapping("/api/v1/rendez-vous/{id}/patient")
    public @ResponseBody ResponseEntity<RDV> createtasksUser(@PathVariable int id,
            @RequestBody RDVPatientRequest rdvpatientDTO) {
        Optional<RDV> resultRDV = RDVRepository.findById(id); 
        if (resultRDV.isEmpty()) { 
            return ResponseEntity.notFound().build();
        }
        RDV rdv = resultRDV.get(); 
        Optional<Patient> result = patientRepository.findById(rdvpatientDTO.getId_patient()); 
                                                                                         
                                                                                         
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        rdv.getPatients().add(result.get()); 
        RDVRepository.save(rdv); 
        return ResponseEntity.ok().body((rdv)); 
    }
  


}
