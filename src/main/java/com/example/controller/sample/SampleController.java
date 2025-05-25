package com.example.controller.sample;

import com.example.command.service.SampleCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sample")
public class SampleController {

  private final SampleCommandService sampleCommandService;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public GetResponse get() {
    return new GetResponse("Hello World!");
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PostResponse post(@RequestBody PostRequest req) {
    var id = sampleCommandService.request(req.body());
    return new PostResponse(id);
  }
}
