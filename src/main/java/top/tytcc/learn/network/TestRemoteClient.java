package top.tytcc.learn.network;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient.Builder;
import top.tytcc.learn.constant.ConfigConstant;
import top.tytcc.learn.constant.TestRemoteClientConstant;


@Component
@RequiredArgsConstructor
public class TestRemoteClient {
  private final Builder client;
  private final TestRemoteClientConstant testRemoteConstant;

  // 虽然此处用了泛型来包装这个返回值，但是似乎并不需要。抽象层次稍微低了一点，具体问题具体分析。
  public <T> T testRemoteCall(String queryParamValue,
                              Class<T> response) {
    return client.baseUrl(testRemoteConstant.getBaseUrl())
        .build()
        .method(HttpMethod.GET)
        .uri(uriBuilder -> uriBuilder
            .path(testRemoteConstant.getUriPath())
            .queryParam(ConfigConstant.INFO_ID_PARAM, queryParamValue)
            .build())
        .header(ConfigConstant.API_KEY_PARAM, testRemoteConstant.getApiKey())
        .retrieve().bodyToMono(response).block();
  }
}
