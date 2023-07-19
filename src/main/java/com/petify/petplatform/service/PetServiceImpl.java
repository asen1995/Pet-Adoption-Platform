package com.petify.petplatform.service;

import com.petify.petplatform.mapper.PetMapper;
import com.petify.petplatform.model.PetDto;
import com.petify.petplatform.mongo.document.PetItem;
import com.petify.petplatform.repository.PetRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl implements IPetService {


    private static final Logger logger = LogManager.getLogger(PetServiceImpl.class);

    private final PetRepository petRepository;

    private final PetMapper petMapper = Mappers.getMapper(PetMapper.class);

    @Autowired
    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
    @Override
    public PetDto createPet(PetDto petDto) {

        logger.info("Creating pet starting...");

        PetItem petItem = petMapper.toPetItem(petDto);
        PetItem saved = petRepository.save(petItem);


        logger.info("Pet saved successfully");

        return petDto;
    }
}
