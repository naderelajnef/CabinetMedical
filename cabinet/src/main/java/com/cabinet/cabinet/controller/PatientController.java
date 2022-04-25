package com.cabinet.cabinet.controller;
import java.util.Optional;

import com.cabinet.cabinet.domain.Patient;
import com.cabinet.cabinet.dto.PatientRequest;
import com.cabinet.cabinet.repository.PatientRepository;


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
//@RequestMapping("")
@CrossOrigin("*")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;
    //lister les patients
    @GetMapping("/app/v1/patients")
    public @ResponseBody ResponseEntity<Iterable<Patient>> find(){
        Iterable<Patient> patients = patientRepository.findAll();
       return ResponseEntity.ok().body(patients);
    }
   
    //lister les patients par {id}::
    @GetMapping("/app/v1/patient/{id}")
    public @ResponseBody ResponseEntity<Patient> getid( @PathVariable int id) {
        Optional<Patient> result = patientRepository.findById(id);
        if (result.isEmpty())
            return ResponseEntity.notFound().build();
        Patient patient = result.get();
        return ResponseEntity.ok().body(patient);
    }
    //creer un nouveau patient 
    @PostMapping("/app/v1/patients")
    public @ResponseBody ResponseEntity<Patient>createpatient( @RequestBody PatientRequest requestDTO){
        Patient p =new Patient();
        p.setNom(requestDTO.getNom());
        p.setPrenom(requestDTO.getPrenom());
        p.setdateNaissance(requestDTO.getdateNaissance());
        p.setTelephone(requestDTO.getTelephone());
        p.setAdresse(requestDTO.getAdresse());
        p.setSocialAccount(requestDTO.getSocialAccount());
        p.setDossierM(requestDTO.getDossierM());
        patientRepository.save(p);
        return ResponseEntity.ok().body((p)); 
    }
    //modifier un patient ::
    @PutMapping("/app/v1/patients/{id}")
    public @ResponseBody ResponseEntity<Patient> modifyPatient(@PathVariable int id,
            @RequestBody PatientRequest requestDTO) {
        Optional<Patient> result = patientRepository.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Patient p = result.get();
        p.setNom(requestDTO.getNom());
        p.setPrenom(requestDTO.getPrenom());
        p.setdateNaissance(requestDTO.getdateNaissance());
        p.setTelephone(requestDTO.getTelephone());
        p.setAdresse(requestDTO.getAdresse());
        p.setSocialAccount(requestDTO.getSocialAccount());
        p.setDossierM(requestDTO.getDossierM());
        patientRepository.save(p);
        return ResponseEntity.ok().body((p));
    }



    //supprimer un patient::
    @CrossOrigin
    @DeleteMapping("/app/v1/patients/{id}")
    public @ResponseBody ResponseEntity<Patient> delete( @PathVariable  int id) {
        Optional<Patient> result = patientRepository.findById(id);
        if (result.isEmpty())
            return ResponseEntity.notFound().build();
            patientRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
