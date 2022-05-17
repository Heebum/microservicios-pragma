package com.micro.imagen.infrastructure.persistence.repository;

import com.micro.imagen.domain.model.ImagenMongo;
import com.micro.imagen.infrastructure.persistence.entity.ImagenMongoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

//@Repository
public interface DataImagenRepository extends MongoRepository<ImagenMongoEntity,String> {

    @Query("{'personaId':?0}")
    List<ImagenMongoEntity> findAllByPerson(Long personaId);
}
