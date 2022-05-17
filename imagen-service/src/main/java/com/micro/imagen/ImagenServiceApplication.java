package com.micro.imagen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"com.micro.imagen.infrastructure", "com.micro.imagen.application"})
public class ImagenServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImagenServiceApplication.class, args);
	}

}
