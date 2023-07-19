package com.petify.petplatform.controller;

import com.petify.petplatform.model.PetDto;
import com.petify.petplatform.service.IPetService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/pets")
public class PetController {


    private static final Logger logger = LogManager.getLogger(PetController.class);

    private final IPetService petService;

    @Autowired
    public PetController(IPetService petService) {
        this.petService = petService;
    }


    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody PetDto productDto) {

        logger.info("Creating pet starting...");
        PetDto pet = petService.createPet(productDto);

        logger.info("Pet saved successfully");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pet);

    }
}
