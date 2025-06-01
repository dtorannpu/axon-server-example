package com.example;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;

@TestConfiguration(proxyBeanMethods = false)
public class MyTestConfig {

  @ServiceConnection
  @Bean
  PostgreSQLContainer<?> postgresDbContainer() {
    return new PostgreSQLContainer<>("postgres:17.5");
  }
}
