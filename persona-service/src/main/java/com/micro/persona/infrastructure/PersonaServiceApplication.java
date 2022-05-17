package com.micro.persona.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"com.micro.persona.infrastructure.feignclients"})
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"com.micro.persona.infrastructure", "com.micro.persona.application"})
//@EntityScan(basePackages = "com.micro.persona.domain")
public class PersonaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonaServiceApplication.class, args);
	}

}
