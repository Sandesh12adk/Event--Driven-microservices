package com.example.demoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class DemoserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoserviceApplication.class, args);
	}

}
