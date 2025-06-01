package com.example.query.projection;

import com.example.event.model.SampleEvent;
import com.example.query.dto.SampleDTO;
import com.example.query.request.SampleQuery;
import com.example.query.service.SampleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class SampleHandler {

  private final SampleService sampleService;

  @EventHandler
  public void on(SampleEvent event) {
    log.info("event received: {}", event);
    sampleService.create(event);
  }

  @QueryHandler
  public SampleDTO handle(SampleQuery query) {
    return sampleService.findById(query);
  }
}
