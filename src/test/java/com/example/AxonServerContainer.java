package com.example;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

public class AxonServerContainer extends GenericContainer<AxonServerContainer> {
  private static final int AXON_PORT = 8024;

  public AxonServerContainer() {
    super(DockerImageName.parse("axoniq/axonserver:2024.2.3"));
    this.withExposedPorts(AXON_PORT);
  }

  public String getAxonServerAddress() {
    return getHost() + ":" + getMappedPort(AXON_PORT);
  }
}
