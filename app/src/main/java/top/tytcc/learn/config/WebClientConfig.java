package top.tytcc.learn.config;

import io.netty.channel.ChannelOption;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;
import reactor.netty.http.client.HttpClient;
import top.tytcc.learn.constant.BaseWebClientConstant;

@Configuration
@RequiredArgsConstructor
public class WebClientConfig {
  private final BaseWebClientConstant baseConstant;

  @Bean
  public Builder baseClient() {
    final var strategies = ExchangeStrategies.builder()
        .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(baseConstant.getMaxMemorySize()))
        .build();

    final var httpClient = HttpClient.create()
        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, baseConstant.getTimeOut());

    return WebClient.builder()
        .exchangeStrategies(strategies)
        .clientConnector(new ReactorClientHttpConnector(httpClient));
  }
}
