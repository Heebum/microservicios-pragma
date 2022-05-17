package com.micro.persona.application.usecase;

import com.micro.persona.application.dto.PersonaEntityDto;
import com.micro.persona.application.mappers.PersonaMapper;
import com.micro.persona.domain.model.Imagen;
import com.micro.persona.domain.model.Persona;
import com.micro.persona.domain.repositories.ImagenFeignService;
import com.micro.persona.domain.usecase.PersonaService;

import java.util.ArrayList;
import java.util.List;

public class PersonaUsecase {
    private final PersonaService personaService;
    private final ImagenFeignService imagenFeignService;
    private final PersonaMapper personaMapper;

    public PersonaUsecase(PersonaService personaService, ImagenFeignService imagenFeignService,PersonaMapper personaMapper) {
        this.personaService = personaService;
        this.imagenFeignService = imagenFeignService;
        this.personaMapper = personaMapper;
    }

    public List<PersonaEntityDto> getAll(){
        List<Persona> data =  personaService.findPersonaAll();
        List<PersonaEntityDto> dto = new ArrayList<>();//personaMapper.toAllDtodata);
        data.forEach( (item)->{
            PersonaEntityDto dto2 = personaMapper.toDto(item);
            dto2.setImagen(imagenFeignService.getByUserId(item.getId()));
            dto.add(dto2);
        });
        return dto;
    }

    public PersonaEntityDto getByID(Long id){
        Persona data = personaService.findPersonaById(id);
        List<Imagen> imagen = imagenFeignService.getByUserId(data.getId());
        PersonaEntityDto dto = personaMapper.toDto(data);
        dto.setImagen(imagen);

        return dto;
    }

    public List<Imagen> getImagens(Long idPersona){
        Persona data = personaService.findPersonaById(idPersona);
        List<Imagen> imagen = personaService.getImages(idPersona);
        return imagen;
    }

}
