package com.taxappy.taxista;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient // Enable eureka client.
@EnableCircuitBreaker // Enable circuit breakers
@EnableFeignClients
public class TaxappyTaxistaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxappyTaxistaApplication.class, args);
	}

}
