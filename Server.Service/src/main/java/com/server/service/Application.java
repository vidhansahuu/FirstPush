package com.server.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer       // THIS IS THE DISCOVERY SERVER AFTER THIS WE WILL ADD EUREKA CLIENT OR DISCOVERY CLIENT..
public class Application {// THIS IS THE SERVER IT WILL CONNECT WITH MICROSERVICES WHICH IS CLIENT BY USING EUREKA CLIENT DEPENDENCY

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}// NOW WE WILL CONVERT OUR MICROSERVICES TO EUREKA CLIENT BY ADDING DEPENDENCIES OF EUREKA CLIENT AND CLOUD BOOTSTRAP
 // SO THAT CLIENT WILL AUTOMATICALLY CONNECT TO EUREKA SERVER DEVELOPED BY US EUREKA SERVER RUNS ON  PORT 8761.
