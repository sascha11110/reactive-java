package loomtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class ReactiveFrontendController {

  private static final Logger LOG = LoggerFactory.getLogger(ReactiveFrontendController.class);

  private final WebClient webClient;

  ReactiveFrontendController(
      WebClient.Builder builder,
      @Value("${backend.url}") String backendUrl
  ) {
    LOG.info("Using base URL " + backendUrl);
    webClient = builder.baseUrl(backendUrl).build();
  }

  @GetMapping("/capabilities")
  Mono<String> capabilities() {
    return webClient.get().uri("/authentication").retrieve().bodyToMono(String.class)
        .flatMap(token -> webClient.get().uri("/authorization/" + token).retrieve().bodyToMono(String.class))
        .flatMap(role -> webClient.get().uri("/capabilities/" + role).retrieve().bodyToMono(String.class));
  }

}
