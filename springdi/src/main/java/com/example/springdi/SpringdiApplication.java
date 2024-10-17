package com.example.springdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringdiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdiApplication.class, args);

		// Injeção no construtor
		Motor motor = new EletricMotor();
		Carro carroEletrico = new Carro(motor);
		motor = new CombustionMotor();
		Carro carroACombustao = new Carro(motor);
		carroEletrico.motorTest();
		carroACombustao.motorTest(); 

		// Injeção por Autowire
		AutowiredLivro livro = new AutowiredLivro(new AutowiredGenero());
		livro.getGenero();
	}
}