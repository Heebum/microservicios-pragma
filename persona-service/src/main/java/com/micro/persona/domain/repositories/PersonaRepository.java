package com.micro.persona.domain.repositories;

import com.micro.persona.domain.model.Persona;

import java.util.List;

public interface PersonaRepository {
    Persona getById(Long id);
    Persona save(Persona persona);
    List<Persona> findAllPersonas();
    Persona update(Persona persona, Long id);
    Persona delete(Long id);
}
