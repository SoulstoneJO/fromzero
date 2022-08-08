package top.tytcc.learn.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.tytcc.learn.common.exception.FromZeroBusinessException;
import top.tytcc.learn.common.exception.FromZeroParameterException;
import top.tytcc.learn.constant.ConfigConstant.ResultCode;
import top.tytcc.learn.model.response.ResultResponse;

@RestControllerAdvice
public class FromZeroHandler {

  @ExceptionHandler(FromZeroParameterException.class)
  public ResultResponse handleParameterException(FromZeroParameterException ex) {
    return ResultResponse.builder()
        .resultCode(ex.getCode().value)
        .message(ex.getMessage())
        .build();
  }

  @ExceptionHandler(FromZeroBusinessException.class)
  public ResultResponse handleBusinessException(FromZeroBusinessException ex) {
    return ResultResponse.builder()
        .resultCode(ex.getCode().value)
        .message(ex.getMessage())
        .build();
  }

  @ExceptionHandler(Exception.class)
  public ResultResponse handleUnExceptException(Exception ex) {
    return ResultResponse.builder()
        .resultCode(ResultCode.NOEXCEPT_ERROR.value)
        .message("UnExceptException")
        .build();
  }
}
