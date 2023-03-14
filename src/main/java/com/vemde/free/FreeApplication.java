package com.vemde.free;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FreeApplication {

	public String PORT = System.getenv("PORT");
	
	
	public static void main(String[] args) {
		var teste = "Teste";
	
		System.out.println(teste.toUpperCase() + " " + "está rolando");
		SpringApplication.run(FreeApplication.class, args);
	}
}
