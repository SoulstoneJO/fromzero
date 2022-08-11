package top.tytcc.learn.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultResponse {
  private String resultCode;
  private String message;
  // ...
}
