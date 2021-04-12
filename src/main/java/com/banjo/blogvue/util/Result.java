package com.banjo.blogvue.util;

import lombok.Data;

@Data
public class Result {

    public static int SUCCESS_CODE = 0;
    public static int FAIL_CODE = 1;

    int code; // 用于传递成功或者失败的代表数字
    String message; // 用于传递成功或者失败的信息
    Object data; // 用于接收返回的数据

    private Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result success() {
        return new Result(SUCCESS_CODE,null,null);
    }
    public static Result success(Object data) {
        return new Result(SUCCESS_CODE,"",data);
    }
    public static Result fail(String message) {
        return new Result(FAIL_CODE,message,null);
    }
}
