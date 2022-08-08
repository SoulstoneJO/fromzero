package top.tytcc.learn.common.exception;

import lombok.Getter;
import top.tytcc.learn.constant.ConfigConstant.ResultCode;

@Getter
public class FromZeroBusinessException extends RuntimeException {
  private final ResultCode code = ResultCode.BUSINESS_ERROR;
  private final String message;

  public FromZeroBusinessException(String message) {
    this.message = message;
  }
}
