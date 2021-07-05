package com.upc.boundservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@SpringBootApplication
@EnableJpaAuditing
public class BoundserviceApplication extends SpringBootServletInitializer {

	/*
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BoundserviceApplication.class);
	}*/

	public static void main(String[] args) {
		SpringApplication.run(BoundserviceApplication.class, args);
	}

	@RestController
	@RequestMapping
	public class TestController {

		@GetMapping
		public ResponseEntity<?> saludo() {
			HashMap<String, String> datos = new HashMap<>();
			datos.put("estado", "1");
			datos.put("descripcion", "TF de Fundamentos de aplicaciones de software");
			return ResponseEntity.status(HttpStatus.OK).body(datos);
		}
	}

}
