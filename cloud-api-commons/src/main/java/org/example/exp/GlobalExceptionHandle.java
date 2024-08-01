package org.example.exp;

import org.example.resp.Resp;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(RuntimeException.class)
    public Resp<String> runtimeHandler(Exception e){
        System.out.println("-------------------全局异常捕捉----------------------");
        e.printStackTrace();
        return Resp.error(null);
    }
}
