package com.micro.imagen.infrastructure.persistence.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.micro.imagen.infrastructure.persistence.repository")
@ConfigurationProperties("spring.datasource")
@EnableMongoAuditing
@EntityScan(basePackages = "com.micro.imagen.infrastructure.persistence.entity")
@Configuration
public class DataConfig {
}
