package org.example.exp;

import org.example.resp.Resp;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //返回非成功状态
    public Resp<String> runtimeHandler(Exception e){
        System.out.println("-------------------全局异常捕捉----------------------");
        e.printStackTrace();
        return Resp.error(null);
    }
}
