package com.niwaz.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan("com.niwaz.demo")
@SpringBootApplication
public class EinNelApplication {

	public static void main(String[] args) {
		SpringApplication.run(EinNelApplication.class, args);
	}

}
