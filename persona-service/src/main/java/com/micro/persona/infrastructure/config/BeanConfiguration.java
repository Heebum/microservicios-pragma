package com.micro.persona.infrastructure.config;

import com.micro.persona.application.mappers.PersonaMapper;
import com.micro.persona.application.usecase.PersonaUsecase;
import com.micro.persona.domain.repositories.PersonaRepository;
import com.micro.persona.domain.repositories.ImagenFeignService;
import com.micro.persona.domain.usecase.PersonaService;
import com.micro.persona.infrastructure.feignclients.ImagenFeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public PersonaService personaService(PersonaRepository personaRepository, ImagenFeignClient imagenFeignClient){
        return new PersonaService(personaRepository,imagenFeignClient);
    }

    @Bean
    public PersonaUsecase personaUsecase(PersonaService personaService, ImagenFeignService imagenFeignService, PersonaMapper personaMapper){
        return new PersonaUsecase(personaService,imagenFeignService,personaMapper);
    }

}
