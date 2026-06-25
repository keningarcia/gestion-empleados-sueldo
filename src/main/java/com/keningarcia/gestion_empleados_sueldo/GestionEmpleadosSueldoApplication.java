package com.keningarcia.gestion_empleados_sueldo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.keningarcia.gestion_empleados_sueldo", "entity", "service", "repository", "dto", "controller", "exception"})
public class GestionEmpleadosSueldoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionEmpleadosSueldoApplication.class, args);
	}

}
