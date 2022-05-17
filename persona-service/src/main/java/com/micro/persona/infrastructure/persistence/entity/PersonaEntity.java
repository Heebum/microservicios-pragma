package com.micro.persona.infrastructure.persistence.entity;

import com.micro.persona.domain.model.Imagen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="personas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String edad;
    private String ciudad;


//    @Transient
//    private Imagen imagen;
}
