package org.example.resp;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true) //链式编程注解
public class Resp<T> {
    private int code;
    private String msg;
    private T data;
    private Long timestamp;

    public Resp() {
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> Resp<T> success(T data) {
        return new Resp<T>().setCode(RespCodeEnum.SUCCESS.getCode()).setMsg(RespCodeEnum.SUCCESS.getMsg()).setData(data);
    }

    public static <T> Resp<T> fail(int code, String msg) {
        return new Resp<T>().setCode(code).setMsg(msg);
    }

    public static <T> Resp<T> error(String info) {
        return new Resp<T>().setCode(RespCodeEnum.ERROR.getCode()).setMsg(info==null? RespCodeEnum.ERROR.getMsg() : info);
    }

}
