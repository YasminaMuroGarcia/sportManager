package com.sportManager.application;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.sportManager.application.service", "com.sportManager.application.converter"})
public class ApplicationConfig {

}
