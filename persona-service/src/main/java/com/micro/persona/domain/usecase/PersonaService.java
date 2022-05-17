package com.micro.persona.domain.usecase;

import com.micro.persona.application.exception.PersonaNotFoundException;
import com.micro.persona.domain.model.Imagen;
import com.micro.persona.domain.model.Persona;
import com.micro.persona.domain.repositories.PersonaRepository;
import com.micro.persona.infrastructure.feignclients.ImagenFeignClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonaService {
    private final PersonaRepository personaRepository;
    private final ImagenFeignClient imagenFeignClient;

    public PersonaService(PersonaRepository personaRepository, ImagenFeignClient imagenFeignClient) {
        this.personaRepository = personaRepository;
        this.imagenFeignClient = imagenFeignClient;
    }

    public Persona findPersonaById(Long id) {
        Persona data = personaRepository.getById(id);
        if (null != data){
            List<Imagen> imagen = imagenFeignClient.getByUserId(data.getId());

        }
        return data;
    }

    public List<Persona> findPersonaAll(){
        List<Persona> personaList = new ArrayList<Persona>();
        personaRepository.findAllPersonas().forEach(personaList::add);
        if (personaList.isEmpty()){
            throw new RuntimeException("No existen personas");
        }
        return personaList;
    }

    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    public Persona update(Persona persona, Long id){
        Optional<Persona> persona1 = Optional.ofNullable(personaRepository.getById(id));
        if (persona1.isEmpty()){
            throw new PersonaNotFoundException(String.format("Persona con id= %s no existe",id));
        }
        Persona personaUpdt =persona1.get();
        personaUpdt.setNombre(persona.getNombre());
        personaUpdt.setApellido(persona.getApellido());
        personaUpdt.setEdad(persona.getEdad());
        personaUpdt.setCiudad(persona.getCiudad());

        personaRepository.update(personaUpdt,id);
        return personaUpdt;
    }

    public Persona delete(Long id){
        Optional<Persona> persona1 = Optional.ofNullable(personaRepository.getById(id));
        if (persona1.isEmpty()){
            throw new PersonaNotFoundException(String.format("Persona con id= %s no existe",id));
        }
        return personaRepository.delete(id);
    }
}
