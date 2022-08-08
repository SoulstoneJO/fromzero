package top.tytcc.learn.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;


public class ConfigConstant {

  @AllArgsConstructor
  public enum ResultCode {
    SUCCESS("0"),
    PARAMETER_ERROR("1"),
    BUSINESS_ERROR("2"),
    NOEXCEPT_ERROR("3");

    public final String value;
  }
}
