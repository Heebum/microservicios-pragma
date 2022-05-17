package com.micro.persona.domain.model;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class Imagen {
    private String _id;
    private String foto;
    private Long personaId;
}
