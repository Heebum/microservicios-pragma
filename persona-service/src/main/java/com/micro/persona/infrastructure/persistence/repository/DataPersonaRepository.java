package com.micro.persona.infrastructure.persistence.repository;

import com.micro.persona.infrastructure.persistence.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataPersonaRepository extends JpaRepository<PersonaEntity, Long> {

}
