package com.micro.persona.application.dto;

import com.micro.persona.domain.model.Imagen;
import lombok.Data;

import javax.persistence.Transient;
import java.util.List;

@Data
public class PersonaEntityDto {
    private final String nombre;
    private final String apellido;
    private final String edad;
    private final String ciudad;
    private List<Imagen> imagen;
}
