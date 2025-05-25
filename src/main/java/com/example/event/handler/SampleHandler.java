package com.example.event.handler;

import com.example.event.model.SampleEvent;
import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SampleHandler {
  private static final Logger logger = LoggerFactory.getLogger(SampleHandler.class);

  @EventHandler
  public void handle(SampleEvent event) {
    logger.info("event received: {}", event);
  }
}
