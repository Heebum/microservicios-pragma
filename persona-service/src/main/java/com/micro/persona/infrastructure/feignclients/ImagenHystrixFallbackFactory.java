package com.micro.persona.infrastructure.feignclients;

import com.micro.persona.domain.model.Imagen;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ImagenHystrixFallbackFactory implements ImagenFeignClient{

    @Override
    public ResponseEntity<Object> getImagenById(String id) {
        Imagen imagen = Imagen.builder()
                .foto("none")
                .personaId(null)
                .build();

        return ResponseEntity.ok(imagen);
    }

    @Override
    public List<Imagen> getByUserId(Long personaId) {
        return null;
    }

    @Override
    public List<Imagen> findAllImages() {
        return null;
    }
}
