package com.petify.petplatform.mapper;

import com.petify.petplatform.model.PetDto;
import com.petify.petplatform.mongo.document.PetItem;
import org.mapstruct.Mapper;

@Mapper
public interface PetMapper {

    PetItem toPetItem(PetDto petDto);

    PetDto toPetDto(PetItem petItem);
}
