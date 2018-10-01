package com.zycus.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.zycus.controllers", "com.zycus.services", "com.zycus.aspects", "com.zycus.dto"})
@EnableJpaRepositories(basePackages = "com.zycus.repository")
@EntityScan(basePackages = "com.zycus.entity")
@EnableCaching
public class Launcher {

	public static void main(String[] args) {
		SpringApplication.run(Launcher.class, args);
	}
}
