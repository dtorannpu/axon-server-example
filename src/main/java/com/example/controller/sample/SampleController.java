package com.example.controller.sample;

import com.example.command.service.SampleCommandService;
import com.example.query.service.SampleQueryService;
import java.util.List;
import java.util.concurrent.ExecutionException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sample")
public class SampleController {

  private final SampleCommandService sampleCommandService;
  private final SampleQueryService sampleQueryService;

  @GetMapping
  public List<GetResponse> list() throws ExecutionException, InterruptedException {
    return sampleQueryService.findAll().stream()
        .map(s -> new GetResponse(s.getId(), s.getBody()))
        .toList();
  }

  @GetMapping("{id}")
  public GetResponse get(@PathVariable Long id) {
    return sampleQueryService
        .get(id)
        .map(s -> new GetResponse(s.getId(), s.getBody()))
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PostResponse post(@RequestBody PostRequest req) {
    var id = sampleCommandService.request(req.getBody());
    return new PostResponse(id);
  }
}
