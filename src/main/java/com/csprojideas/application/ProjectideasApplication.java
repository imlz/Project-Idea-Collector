package com.csprojideas.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class ProjectideasApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectideasApplication.class, args);

	}

}