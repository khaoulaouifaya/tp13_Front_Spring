package com.tp13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.tp13.models.Client;

@SpringBootApplication
public class SpringFrontTp13Application {

	
	
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
		
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringFrontTp13Application.class, args);
	}
	
		

}
