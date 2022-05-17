package loomtest;

import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient.Builder;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

@Component
public class HighVolumeWebClientCustomizer implements WebClientCustomizer {

  @Override
  public void customize(Builder webClientBuilder) {
    var connectionProvider = ConnectionProvider.builder("myConnectionPool")
        .maxConnections(20_000)
        .build();
    var clientHttpConnector = new ReactorClientHttpConnector(HttpClient.create(connectionProvider));
    webClientBuilder.clientConnector(clientHttpConnector);
  }

}
