package com.eventscheduler.eventschedulerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

// @ComponentScan(basePackages = {"com.eventscheduler"})
public class EventschedulerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventschedulerAppApplication.class, args);
	}

}
