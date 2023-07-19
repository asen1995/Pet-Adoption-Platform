package com.petify.petplatform.repository;

import com.petify.petplatform.mongo.document.PetItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends MongoRepository<PetItem, String> {
}
