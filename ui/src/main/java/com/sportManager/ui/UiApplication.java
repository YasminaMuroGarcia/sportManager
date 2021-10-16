package com.sportManager.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.sportManager.application.ApplicationConfig;
import com.sportManager.infrastructure.InfrastructureConfig;
import com.sportManager.model.ModelConfig;

@SpringBootApplication
@Import({UiConfig.class, ApplicationConfig.class, ModelConfig.class, InfrastructureConfig.class})
public class UiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UiApplication.class, args);
	}

}
