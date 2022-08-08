package top.tytcc.learn.common.exception;

import lombok.Getter;
import top.tytcc.learn.constant.ConfigConstant.ResultCode;

@Getter
public class FromZeroParameterException extends RuntimeException {
  private final ResultCode code = ResultCode.PARAMETER_ERROR;
  private final String message;

  public FromZeroParameterException(String message) {
    this.message = message;
  }
}
