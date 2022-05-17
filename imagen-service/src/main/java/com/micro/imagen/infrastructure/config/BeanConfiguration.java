package com.micro.imagen.infrastructure.config;

import com.micro.imagen.domain.repositories.ImagenRepository;
import com.micro.imagen.domain.usecase.ImagenService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ImagenService imagenService(ImagenRepository imagenRepository){
        return new ImagenService(imagenRepository);
    }
}
