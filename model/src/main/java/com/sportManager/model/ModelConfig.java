package com.sportManager.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.sportManager.model.impl"})
@EntityScan({"com.sportManager.model.impl"})
public class ModelConfig {

}
