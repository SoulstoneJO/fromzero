package top.tytcc.learn.common.exception;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ControllerExceptionAspect {

  @Around("execution(* top.tytcc.learn.controller.TestController.*(..))")
  public Object exceptionHandle(ProceedingJoinPoint pjp) throws Throwable {
    try {
      return pjp.proceed();
    } catch (Exception ex) {
      final var parameterNameList = ((CodeSignature) pjp.getSignature()).getParameterNames();
      final var valueList = pjp.getArgs();
      final var messageList = new String[parameterNameList.length];

      for (int i = 0; i < parameterNameList.length; i++) {
        messageList[i] = parameterNameList[i] + valueList[i];
      }

      final var errorMessage =
          String.format("%s - Exception happened. Request INFO: %s", pjp.getSignature().getName(),
              Arrays.toString(messageList));

      log.error(errorMessage, ex);

      throw ex;
    }
  }
}
