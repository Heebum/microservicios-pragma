package com.micro.persona.infrastructure.persistence.mapper;

import com.micro.persona.domain.model.Persona;
import com.micro.persona.infrastructure.persistence.entity.PersonaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonaEntityMapper {

    Persona toDomaindb(PersonaEntity personaEntity);
    PersonaEntity toDb(Persona persona);
    List<Persona> toAllDb(List<PersonaEntity> entityList);
}
