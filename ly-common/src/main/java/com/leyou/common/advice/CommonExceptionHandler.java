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
        return ResponseEntity.status(e.getExceptionEnum().getCode())
                .body(new ExceptionResult(e.getExceptionEnum()));
    }
}
