package top.tytcc.learn.constant;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties("remote")
public class BaseWebClientConstant {
  private int maxMemorySize;
  private int timeOut;
}
