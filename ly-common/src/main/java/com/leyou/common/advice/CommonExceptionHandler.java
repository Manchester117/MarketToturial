package com.leyou.common.advice;

import com.leyou.common.exception.LyException;
import com.leyou.common.vo.ExceptionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @description 通用异常处理的Controller拦截
 */
@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(LyException.class)           // 可以通过使用注解的参数来拦截不同的异常
    public ResponseEntity<ExceptionResult> handlerException(LyException e) {
        // 拿到异常状态码
        int exceptionCode = e.getExceptionEnum().getCode();
        // 封装异常实体
        ExceptionResult exceptionResult = new ExceptionResult(e.getExceptionEnum());
        // 返回响应实体的状态码 + 异常信息
        return ResponseEntity.status(exceptionCode).body(exceptionResult);
    }
}
