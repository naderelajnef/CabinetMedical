package com.cabinet.cabinet.controller;

import com.cabinet.cabinet.domain.Assistant;

import com.cabinet.cabinet.dto.AssistantRequest;
import com.cabinet.cabinet.repository.AssistantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssistantController {

    @Autowired
    private AssistantRepository assistantRepository;

    @GetMapping("/app/v1/assistant")
    public @ResponseBody ResponseEntity<Iterable<Assistant>> find(){
        Iterable<Assistant>  assistant = assistantRepository.findAll();
        return ResponseEntity.ok().body(assistant);
    }
    @PostMapping("/app/v1/assistant")
    public @ResponseBody ResponseEntity<Assistant> create( @RequestBody AssistantRequest requestDTO){
        Assistant assistant =new Assistant();
        assistant.setNom(requestDTO.getNom());
        assistant.setPrenom(requestDTO.getNom());
        assistantRepository.save(assistant);
        return ResponseEntity.ok().body(assistant);
    }
    
}
