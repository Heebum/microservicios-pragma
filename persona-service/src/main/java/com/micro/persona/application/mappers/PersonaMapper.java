package com.micro.persona.application.mappers;

import com.micro.persona.application.dto.PersonaEntityDto;
import com.micro.persona.domain.model.Persona;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonaMapper {
    PersonaEntityDto toDto(Persona persona);
    Persona toDomain(PersonaEntityDto personaEntityDto);
    List<PersonaEntityDto> toAllDto(List<Persona> personaList);
}
