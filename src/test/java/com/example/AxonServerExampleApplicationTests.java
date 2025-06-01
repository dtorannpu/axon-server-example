package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
@Import(MyTestConfig.class)
class AxonServerExampleApplicationTests {
  @Container static AxonServerContainer axonServer = new AxonServerContainer();

  @DynamicPropertySource
  static void axonProps(DynamicPropertyRegistry registry) {
    registry.add("axon.axonserver.servers", axonServer::getAxonServerAddress);
    registry.add("axon.axonserver.enabled", () -> "true");
    registry.add("axon.axonserver.dev-mode.enabled", () -> "true");
  }

  @Test
  void contextLoads() {}
}
