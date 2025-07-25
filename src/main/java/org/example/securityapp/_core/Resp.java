package org.example.securityapp._core;

import lombok.Data;

@Data
public class Resp<T> {
    private boolean success;
    private Integer status;
    private String msg;
    private T data;

    // static factory method로 만들 때 제네릭 타입 결정 : 공부해볼 것

    public Resp() {
        this.success = true;
        this.status = 200;
        this.msg = "성공";
        this.data = null;

    }

    public Resp(T data) {
        this.success = true;
        this.status = 200;
        this.msg = "성공";
        this.data = data;

    }

    public Resp(Integer statusCode, String msg) {
        this.success = false;
        this.status = statusCode;
        this.msg = msg;
        this.data = null;
    }
}
