package org.example.resp;

import lombok.Data;
import lombok.Getter;
@Getter
public enum RespCodeEnum {
    SUCCESS(200, "成功"),
    ERROR(500, "服务器错误");

    private int code;
    private String msg;
    RespCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
