package com.micro.persona.infrastructure.endpoints;

import com.micro.persona.application.dto.PersonaEntityDto;
import com.micro.persona.application.exception.PersonaNotFoundException;
import com.micro.persona.application.mappers.PersonaMapper;
import com.micro.persona.application.usecase.PersonaUsecase;
import com.micro.persona.domain.model.Imagen;
import com.micro.persona.domain.model.Persona;
import com.micro.persona.domain.usecase.PersonaService;
import com.micro.persona.infrastructure.feignclients.ImagenFeignClient;
import com.netflix.discovery.converters.Auto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @Autowired
    PersonaMapper personaMapper;

    @Autowired
    ImagenFeignClient imagenFeignClient;

    @Autowired
    PersonaUsecase personaUsecase;

    @ApiOperation(value="Crear nueva Persona", notes="Proporciona una operación para crear un nuevo objeto Persona y devolver su identificador")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "Created", response = String.class),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)
    })
    @PostMapping(produces = "application/json; charset=UTF-8")
    public ResponseEntity<Object> createPerson(@RequestBody PersonaEntityDto personaEntityDto){

        return new ResponseEntity<>(personaMapper.toDto(personaService.save(personaMapper.toDomain(personaEntityDto))), HttpStatus.CREATED);

    }
    @ApiOperation(value="Obtener persona por id", notes="Proporciona una operación para obtener un objeto Persona por su identificador")
    @ApiResponses(value={
            @ApiResponse(code=200, message="OK", response= Persona.class),
            @ApiResponse(code=404, message="Not Found", response=String.class),
            @ApiResponse(code=500, message="Internal Server Error", response=String.class)
    })
    @GetMapping(value = "/{id}", produces = "application/json; charset=UTF-8")
    public ResponseEntity<Object> getPersonaById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(personaUsecase.getByID(id), HttpStatus.OK);
        }catch (PersonaNotFoundException e){
            Map<String,String> errors = new HashMap<>();
            errors.put("mensaje",e.getMessage());
            return new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value="Obtener todas las persona", notes="Proporciona una operación para obtener todas las Persona")
    @ApiResponses(value={
            @ApiResponse(code=200, message="OK", response= Persona.class),
            @ApiResponse(code=404, message="Not Found", response=String.class),
            @ApiResponse(code=500, message="Internal Server Error", response=String.class)
    })
    @GetMapping(produces = "application/json; charset=UTF-8")
    public ResponseEntity<Object> findAllPerson(){
        try {
            return new ResponseEntity<>(personaUsecase.getAll(),HttpStatus.OK);
        }catch (Exception e){
            Map<String,String> errors = new HashMap<>();
            errors.put("mensaje",e.getMessage());
            return new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value="Actualizar persona por id", notes="Proporciona una operación para actualizar un objeto Persona por su identificador")
    @ApiResponses(value={
            @ApiResponse(code=200, message="OK", response= Persona.class),
            @ApiResponse(code=404, message="Not Found", response=String.class),
            @ApiResponse(code=500, message="Internal Server Error", response=String.class)
    })
    @PutMapping(value = "/{id}",produces = "application/json; charset=UTF-8")
    public ResponseEntity<Object> updatePerson(@PathVariable Long id, @RequestBody PersonaEntityDto personaEntityDto){

        return new ResponseEntity<>(personaMapper.toDto(personaService.update(personaMapper.toDomain(personaEntityDto),id)),HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}",produces = "application/json; charset=UTF-8")
    public ResponseEntity<Object> deletePerson(@PathVariable Long id){
        return new ResponseEntity<>(personaMapper.toDto(personaService.delete(id)),HttpStatus.OK);
    }
}
