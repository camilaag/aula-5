package br.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.entity.**", "br.com.repository.**", "br.com.controller.**", "br.com.servico.**"})
public class Aula5Application {

	public static void main(String[] args) {
		SpringApplication.run(Aula5Application.class, args);
	}

}
