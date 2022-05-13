package com.micro.persona.domain.repositories;

import com.micro.persona.domain.model.Imagen;

import java.util.List;

public interface ImagenFeignService {
    List<Imagen> getByUserId(Long personaId);
}
