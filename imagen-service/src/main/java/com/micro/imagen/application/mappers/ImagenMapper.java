package com.micro.imagen.application.mappers;

import com.micro.imagen.application.dto.ImagenMongoEntityDto;
import com.micro.imagen.domain.model.ImagenMongo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImagenMapper {

    ImagenMongoEntityDto toDto(ImagenMongo imagenMongo);
    ImagenMongo toDomain(ImagenMongoEntityDto imagenMongoEntityDto);
    List<ImagenMongoEntityDto> toAllDto(List<ImagenMongo> mongoList);
}
