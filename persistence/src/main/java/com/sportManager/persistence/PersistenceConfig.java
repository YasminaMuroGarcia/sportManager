package com.sportManager.persistence;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.sportManager.persistence.repository", "com.sportManager.persistence.model.factory"})
@EntityScan({"com.sportManager.persistence.model.impl"})
public class PersistenceConfig {

}
