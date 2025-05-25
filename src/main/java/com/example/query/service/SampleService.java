package com.example.query.service;

import com.example.event.model.SampleEvent;
import com.example.infrastructure.entity.Sample;
import com.example.infrastructure.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SampleService {

  private final SampleRepository repository;

  @Transactional
  public void create(SampleEvent event) {
    Sample sample = new Sample();
    sample.setBody(event.body());
    repository.save(sample);
  }
}
