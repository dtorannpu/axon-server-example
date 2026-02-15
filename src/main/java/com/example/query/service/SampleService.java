package com.example.query.service;

import com.example.event.model.SampleEvent;
import com.example.infrastructure.entity.Sample;
import com.example.infrastructure.repository.SampleRepository;
import com.example.query.dto.SampleDTO;
import com.example.query.dto.SampleListDto;
import com.example.query.request.SampleQuery;
import java.util.stream.Collectors;
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
    sample.setBody(event.getBody());
    repository.save(sample);
  }

  public SampleDTO findById(SampleQuery query) {
    return repository
        .findById(query.getId())
        .map(s -> new SampleDTO(s.getId(), s.getBody()))
        .orElse(null);
  }

  public SampleListDto findAll() {
    return new SampleListDto(
        repository.findAll().stream()
            .map(s -> new SampleDTO(s.getId(), s.getBody()))
            .collect(Collectors.toList()));
  }
}
