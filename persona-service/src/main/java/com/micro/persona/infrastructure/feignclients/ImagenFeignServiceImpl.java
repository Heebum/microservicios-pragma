package com.micro.persona.infrastructure.feignclients;

import com.micro.persona.domain.model.Imagen;
import com.micro.persona.domain.repositories.ImagenFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagenFeignServiceImpl implements ImagenFeignService {
    @Autowired
    ImagenFeignClient imagenFeignClient;

    @Override
    public List<Imagen> getByUserId(Long personaId) {
        return imagenFeignClient.getByUserId(personaId);
    }
}
