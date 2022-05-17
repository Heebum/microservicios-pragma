package com.micro.imagen.domain.repositories;

import com.micro.imagen.domain.model.ImagenMongo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public interface ImagenRepository {

    ImagenMongo getById(String _id);
    ImagenMongo save(ImagenMongo imagenMongo);
    Collection<ImagenMongo> findAllImages();
    ImagenMongo update(MultipartFile file, Long fk_persona, String id) throws IOException;
    ImagenMongo delete(String _id);
    List<ImagenMongo> findByPersonaId(Long personaId);
}
