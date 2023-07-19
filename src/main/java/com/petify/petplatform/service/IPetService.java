package com.petify.petplatform.service;

import com.petify.petplatform.model.PetDto;

public interface IPetService {
    PetDto createPet(PetDto petDto);
}
