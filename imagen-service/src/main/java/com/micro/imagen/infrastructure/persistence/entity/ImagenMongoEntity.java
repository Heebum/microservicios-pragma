package com.micro.imagen.infrastructure.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "ImagenMongoEntity")
public class ImagenMongoEntity {
    @Id
    private String _id;
    private String foto;

    @Indexed(unique = false)
    private Long personaId;

}
