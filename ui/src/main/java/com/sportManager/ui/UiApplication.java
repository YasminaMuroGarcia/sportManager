package com.sportManager.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.sportManager.application.ApplicationConfig;
import com.sportManager.domain.DomainConfig;
import com.sportManager.persistence.PersistenceConfig;

@SpringBootApplication
@Import({UiConfig.class, ApplicationConfig.class, DomainConfig.class, PersistenceConfig.class})
public class UiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UiApplication.class, args);
	}

}
