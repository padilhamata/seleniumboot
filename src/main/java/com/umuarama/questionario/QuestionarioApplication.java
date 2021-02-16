package com.umuarama.questionario;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.umuarama.questionario.selenium.Principal;

@SpringBootApplication
public class QuestionarioApplication {

	public static void main(String[] args) throws InterruptedException, IOException {
		SpringApplication.run(QuestionarioApplication.class, args);
		
	}

}
