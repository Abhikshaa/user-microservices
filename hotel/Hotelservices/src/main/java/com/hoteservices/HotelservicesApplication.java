package com.hoteservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HotelservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelservicesApplication.class, args);
	}

}
