package com.formacionbdi.sprintboot.app.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SprintbootServicioProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintbootServicioProductosApplication.class, args);
	}

}
