package top.tytcc.learn.constant;

import lombok.AllArgsConstructor;

public class ConfigConstant {
  public static final String INFO_ID_PARAM="info_id";
  public static final String API_KEY_PARAM="X-API-KEY";

  @AllArgsConstructor
  public enum ResultCode {
    SUCCESS("0"),
    PARAMETER_ERROR("1"),
    BUSINESS_ERROR("2"),
    NOEXCEPT_ERROR("3");

    public final String value;
  }
}
