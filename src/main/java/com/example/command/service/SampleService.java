package com.example.command.service;

import com.example.command.dto.SampleCommand;
import java.util.UUID;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

  private final CommandGateway commandGateway;

  public SampleService(CommandGateway commandGateway) {
    this.commandGateway = commandGateway;
  }

  private static final Logger logger = LoggerFactory.getLogger(SampleService.class);

  @CommandHandler
  public UUID request(String body) {
    var id = UUID.randomUUID();
    var command = new SampleCommand(id, body);
    logger.info("command send: {}", command);
    commandGateway.sendAndWait(command);
    return id;
  }
}
