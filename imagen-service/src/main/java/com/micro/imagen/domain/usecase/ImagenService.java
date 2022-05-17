package com.micro.imagen.domain.usecase;

import com.micro.imagen.application.exception.ImagenNotFoundException;
import com.micro.imagen.domain.model.ImagenMongo;
import com.micro.imagen.domain.repositories.ImagenRepository;
import com.micro.imagen.infrastructure.persistence.entity.ImagenMongoEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

public class ImagenService {

//    private final PersonaRepository personaRepository;
    private final ImagenRepository imagenRepository;

    public ImagenService(ImagenRepository imagenRepository) {//PersonaRepository personaRepository,
//        this.personaRepository = personaRepository;
        this.imagenRepository = imagenRepository;
    }

    public ImagenMongo findImagenById(String _id){
        return imagenRepository.getById(_id);
    }

    public List<ImagenMongo> findImagenAll(){
        List<ImagenMongo> listar = new ArrayList<ImagenMongo>();
        imagenRepository.findAllImages().forEach(listar::add);
        if (listar.isEmpty()){
            throw new RuntimeException("No existen imagenes");
        }
        return listar;
    }
    public ImagenMongo save(MultipartFile file, Long fk_persona) throws IOException {
        ImagenMongo image = new ImagenMongo();
        byte[] fileContent = file.getBytes();
        String encodedString = Base64
                .getEncoder()
                .encodeToString(fileContent);
        image.setFoto(encodedString);
        image.setPersonaId(fk_persona);

//        Optional<Persona> persona = Optional.ofNullable(personaRepository.getById(Long.valueOf(fk_persona)));
//        if (persona.isEmpty()){
//            throw new PersonaNotFoundException(String.format("Persona con id= %s no existe",fk_persona));
//        }
//        image.setPersona(persona.orElseThrow());

        return imagenRepository.save(image);
    }
    public ImagenMongo update(MultipartFile file, Long fk_persona, String _id) throws IOException {

        Optional<ImagenMongo> imagenMongo = Optional.ofNullable(imagenRepository.getById(_id));
        if (imagenMongo.isEmpty()){
            throw new ImagenNotFoundException(_id);
        }
        ImagenMongo update = imagenMongo.orElseThrow();
        byte[] fileContent = file.getBytes();
        String encodedString = Base64
                .getEncoder()
                .encodeToString(fileContent);
        update.setFoto(encodedString);
        update.setPersonaId(fk_persona);

//        Optional<Persona> persona1 = Optional.ofNullable(personaRepository.getById(Long.valueOf(fk_persona)));
//        if (persona1.isEmpty()){
//            throw new PersonaNotFoundException(String.format("Persona con id= %s no existe",fk_persona));
//        }
//        update.setPersona(persona1.orElseThrow());

        imagenRepository.update(file,fk_persona,_id);
        return update;
    }
    public ImagenMongo delete(String _id){
        Optional<ImagenMongo> imagenMongo = Optional.ofNullable(imagenRepository.getById(_id));
        if (imagenMongo.isEmpty()){
            throw new ImagenNotFoundException(_id);
        }

        return imagenRepository.delete(_id);
    }

    public List<ImagenMongo> findByPersonaId(Long personaId){
//        List<ImagenMongo> listByPerson = new ArrayList<ImagenMongo>();
//        imagenRepository.findByPersonaId(personaId).forEach(listByPerson::add);
        List<ImagenMongo> listByPerson = imagenRepository.findByPersonaId(personaId);
        return listByPerson;
    }
}
