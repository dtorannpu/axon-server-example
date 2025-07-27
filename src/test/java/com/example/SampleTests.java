package com.example;

import com.example.query.dto.SampleDTO;
import org.junit.jupiter.api.Test;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

public class SampleTests {
  @Test
  void test() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();

    SampleDTO sampleDTO = new SampleDTO(1L, "test");
    System.out.println(objectMapper.writeValueAsString(sampleDTO));
  }
}
