package com.example.command.handler;

import com.example.command.dto.SampleCommand;
import com.example.event.model.SampleEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.gateway.EventGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SampleCommandHandler {

  private static final Logger logger = LoggerFactory.getLogger(SampleCommandHandler.class);

  private final EventGateway eventGateway;

  public SampleCommandHandler(EventGateway eventGateway) {
    this.eventGateway = eventGateway;
  }

  @CommandHandler
  public void run(SampleCommand command) {
    var event = new SampleEvent(command.docId(), command.body());
    logger.info("event created: {}", event);
    eventGateway.publish(event);
  }
}
