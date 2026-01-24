package com.example.query.service;

import com.example.query.dto.SampleDTO;
import com.example.query.dto.SampleListDTO;
import com.example.query.request.SampleFindAllQuery;
import com.example.query.request.SampleQuery;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.queryhandling.gateway.QueryGateway;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SampleQueryService {

  private final QueryGateway queryGateway;

  public Optional<SampleDTO> get(Long id) {
    return Optional.ofNullable(queryGateway.query(new SampleQuery(id), SampleDTO.class).join());
  }

  public SampleListDTO findAll() {
    return queryGateway.query(new SampleFindAllQuery(), SampleListDTO.class).join();
  }
}
