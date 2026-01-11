package com.example.query.projection;

import com.example.event.model.SampleEvent;
import com.example.query.dto.SampleDTO;
import com.example.query.dto.SampleListDTO;
import com.example.query.request.SampleFindAllQuery;
import com.example.query.request.SampleQuery;
import com.example.query.service.SampleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.messaging.eventhandling.annotation.EventHandler;
import org.axonframework.messaging.queryhandling.annotation.QueryHandler;
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

  @QueryHandler
  public SampleListDTO handlerFindAll(SampleFindAllQuery query) {
    return new SampleListDTO(sampleService.findAll());
  }
}
