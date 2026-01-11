package com.example.command.handler;

import com.example.command.dto.SampleCommand;
import com.example.event.model.SampleEvent;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.messaging.commandhandling.annotation.CommandHandler;
import org.axonframework.messaging.eventhandling.gateway.EventGateway;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class SampleCommandHandler {
  private final EventGateway eventGateway;

  @CommandHandler
  public void run(SampleCommand command) {
    var event = new SampleEvent(command.docId(), command.body());
    log.info("event created: {}", event);
    eventGateway.publish(List.of(event));
  }
}
