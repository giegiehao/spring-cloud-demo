package org.example.exp;

import org.example.resp.Resp;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(RuntimeException.class)
    public Resp<String> runtimeHandler(RuntimeException e){
        e.printStackTrace();
        return Resp.error(null);
    }
}
