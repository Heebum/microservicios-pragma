package com.micro.imagen.infrastructure.persistence.repository;

import com.micro.imagen.application.exception.ImagenNotFoundException;
import com.micro.imagen.domain.model.ImagenMongo;
import com.micro.imagen.domain.repositories.ImagenRepository;
import com.micro.imagen.infrastructure.persistence.entity.ImagenMongoEntity;
import com.micro.imagen.infrastructure.persistence.mapper.ImagenEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class DataImagenRepositoryImpl implements ImagenRepository {

    @Autowired
    DataImagenRepository dataImagenRepository;
//    @Autowired
//    DataPersonaRepository dataPersonaRepository;
    @Autowired
    ImagenEntityMapper imagenEntityMapper;
//    @Autowired
//    PersonaEntityMapper personaEntityMapper;

    @Override
    public ImagenMongo getById(String _id) {
        return imagenEntityMapper.toDomainDb(dataImagenRepository.findById(_id).orElseThrow( ()-> new ImagenNotFoundException(_id)));
    }

    @Override
    public ImagenMongo save(ImagenMongo imagenMongo) {
        return imagenEntityMapper.toDomainDb(dataImagenRepository.save(imagenEntityMapper.toDb(imagenMongo)));
    }

    @Override
    public Collection<ImagenMongo> findAllImages() {
        List<ImagenMongoEntity> listar = new ArrayList<ImagenMongoEntity>();
        dataImagenRepository.findAll().forEach(listar::add);
        return imagenEntityMapper.toAllDb(listar);
    }

    @Override
    public ImagenMongo update(MultipartFile file, Long fk_persona, String id) throws IOException {
        ImagenMongoEntity image = dataImagenRepository.findById(id).orElseThrow( ()-> new ImagenNotFoundException(id));
        ImagenMongoEntity update = image;
        byte[] fileContent = file.getBytes();
        String encodedString = Base64
                .getEncoder()
                .encodeToString(fileContent);
        image.setFoto(encodedString);
        image.setPersonaId(fk_persona);

//        PersonaEntity persona1 = dataPersonaRepository.findById(Long.valueOf(fk_persona)).orElseThrow( ()-> new PersonaNotFoundException(String.format("Persona con id= %s no existe",fk_persona)));
//        image.setPersona(personaEntityMapper.toDomaindb(persona1));

        return imagenEntityMapper.toDomainDb(dataImagenRepository.save(image));
    }

    @Override
    public ImagenMongo delete(String _id) {
        ImagenMongoEntity image = dataImagenRepository.findById(_id).orElseThrow( ()-> new ImagenNotFoundException(_id));
        dataImagenRepository.deleteById(_id);
        return imagenEntityMapper.toDomainDb(image);
    }

    @Override
    public List<ImagenMongo> findByPersonaId(Long personaId){

        List<ImagenMongoEntity> listByPerson = dataImagenRepository.findAllByPerson(personaId);
//        System.out.println("listByPerson2 "+listByPerson);
        return imagenEntityMapper.toAllPersonDb(listByPerson);
    }
}
