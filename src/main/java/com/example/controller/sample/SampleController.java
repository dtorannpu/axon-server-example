package com.example.controller.sample;

import com.example.command.dto.SampleCommand;
import com.example.command.service.SampleService;
import java.util.UUID;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sample")
public class SampleController {

  private final SampleService sampleService;

  public SampleController(SampleService sampleService) {
    this.sampleService = sampleService;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public GetResponse get() {
    return new GetResponse("Hello World!");
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PostResponse post(@RequestBody PostRequest req) {
    var id = sampleService.request(req.body());
    return new PostResponse(id);
  }
}
