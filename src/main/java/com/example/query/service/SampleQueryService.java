package com.example.query.service;

import com.example.query.dto.SampleDTO;
import com.example.query.dto.SampleListDTO;
import com.example.query.request.SampleFindAllQuery;
import com.example.query.request.SampleQuery;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SampleQueryService {

  private final QueryGateway queryGateway;

  public Optional<SampleDTO> get(Long id) {
    return queryGateway
        .query(new SampleQuery(id), ResponseTypes.optionalInstanceOf(SampleDTO.class))
        .join();
  }

  public SampleListDTO findAll() throws ExecutionException, InterruptedException {
    return queryGateway
        .query(new SampleFindAllQuery(), ResponseTypes.instanceOf(SampleListDTO.class))
        .get();
  }
}
