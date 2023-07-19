package com.petify.petplatform.controller;

import com.petify.petplatform.model.PetDto;
import com.petify.petplatform.service.IPetService;
import com.petify.petplatform.util.URICreator;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

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
        String id = petService.createPet(productDto);

        logger.info("Pet saved successfully");

        return ResponseEntity.created(URI.create(URICreator.getSelfLink(id)))
                .body(id);

    }

    @GetMapping("/{id}")
    public ResponseEntity<PetDto> get(@PathVariable String id) {

        if(id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Id cannot be null or empty");
        }

        logger.info("Getting pet with id: {}", id);
        PetDto petDto = petService.getPetById(id);
        logger.info("Pet with id: {} successfully got", id);

        return ResponseEntity.ok(petDto);
    }

}
