package com.micro.imagen.infrastructure.persistence.mapper;

import com.micro.imagen.domain.model.ImagenMongo;
import com.micro.imagen.infrastructure.persistence.entity.ImagenMongoEntity;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ImagenEntityMapper {

    ImagenMongo toDomainDb(ImagenMongoEntity imagenMongoEntity);
    ImagenMongoEntity toDb(ImagenMongo imagenMongo);
    Collection<ImagenMongo> toAllDb(List<ImagenMongoEntity> imagenMongoEntity);
    List<ImagenMongo> toAllPersonDb(List<ImagenMongoEntity> imagenMongoEntity);
}
