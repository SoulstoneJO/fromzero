package top.tytcc.learn.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.tytcc.learn.common.ResultResponse;
import top.tytcc.learn.common.exception.FromZeroParameterException;
import top.tytcc.learn.common.exception.FromZeroBusinessException;
import top.tytcc.learn.constant.ConfigConstant.ResultCode;

@RestControllerAdvice
public class FromZeroHandler {

  @ExceptionHandler(FromZeroParameterException.class)
  public ResponseEntity<ResultResponse> handleParameterException(FromZeroParameterException ex) {
    return ResponseEntity.ok(ResultResponse.builder()
        .resultCode(ex.getCode().value)
        .message(ex.getMessage())
        .build());
  }

  @ExceptionHandler(FromZeroBusinessException.class)
  public ResponseEntity<ResultResponse> handleBusinessException(FromZeroBusinessException ex) {
    return ResponseEntity.ok(ResultResponse.builder()
        .resultCode(ex.getCode().value)
        .message(ex.getMessage())
        .build());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ResultResponse> handleUnExceptException(Exception ex) {
    return ResponseEntity.ok(ResultResponse.builder()
        .resultCode(ResultCode.NOEXCEPT_ERROR.value)
        .message("UnExceptException")
        .build());
  }
}
