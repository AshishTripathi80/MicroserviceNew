package com.busservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BusServiceApplication {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();}

	public static void main(String[] args) {
		SpringApplication.run(BusServiceApplication.class, args);
	}

}
