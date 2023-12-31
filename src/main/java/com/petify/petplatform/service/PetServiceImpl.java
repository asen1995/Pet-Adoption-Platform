package com.petify.petplatform.service;

import com.petify.petplatform.exception.PetNotFoundException;
import com.petify.petplatform.mapper.PetMapper;
import com.petify.petplatform.model.PetDto;
import com.petify.petplatform.mongo.document.PetItem;
import com.petify.petplatform.repository.PetRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;

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
    public String createPet(PetDto petDto) {

        logger.info("Creating pet starting...");

        PetItem petItem = petMapper.toPetItem(petDto);
        petItem.setRegisteredDate(new Date());

        PetItem saved = petRepository.save(petItem);

        logger.info("Pet saved successfully");

        return saved.getId();
    }

    @Override
    @Cacheable("pets")
    public PetDto getPetById(String id) {

        logger.info("Getting pet with id: {}", id);
        PetItem petItem = petRepository.findById(id).orElseThrow(PetNotFoundException::new);

        PetDto petDto = petMapper.toPetDto(petItem);
        logger.info("Pet with id: {} successfully got", id);

        return petDto;
    }
}
