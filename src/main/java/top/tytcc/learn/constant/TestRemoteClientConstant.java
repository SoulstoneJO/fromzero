package top.tytcc.learn.constant;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class TestRemoteClientConstant {
    @Value("${test_remote_base_url}")
    private String baseUrl;

    @Value("${test_remote_uri_path}")
    private String uriPath;

    @Value("${test_remote_query_param_value}")
    private String queryParamValue;

    @Value("${x_api_key}")
    private String apiKey;
}
