package com.micro.persona.infrastructure.feignclients;

import com.micro.persona.domain.model.Imagen;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "imagen-service",path = "/api/imagenMongo", url = "http://localhost:8092")//  fallback = ImagenHystrixFallbackFactory.class

public interface ImagenFeignClient {

    @GetMapping(value = "/{id}", produces = "application/json; charset=UTF-8")
    ResponseEntity<Object> getImagenById(@PathVariable String id);

    @GetMapping(value = "/bypersona/{personaId}", produces = "application/json; charset=UTF-8")
    List<Imagen> getByUserId(@PathVariable("personaId") Long personaId);

    @GetMapping(value = "/allimages")
    List<Imagen> findAllImages();
}
