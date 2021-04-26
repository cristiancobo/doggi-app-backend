package com.app.doggi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DoggiApplication {

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	public static final String API_COUNTRIES_API_BASE_URL = "https://countries-backend-api.herokuapp.com/api/v1.0/countries/";

	public static void main(String[] args) {
		SpringApplication.run(DoggiApplication.class, args);
	}

}
