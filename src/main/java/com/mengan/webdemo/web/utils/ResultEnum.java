package com.mengan.webdemo.web.utils;

public enum ResultEnum {

    SUCCESS(200,"操作成功"),
    EXCEPTION(501, "业务异常");

    /**
     * 响应码
     */
    private int code;

    /**
     * 响应消息
     */
    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 获取响应码
     * @return int
     */
    public int getCode() {
        return code;
    }

    /**
     * 获取响应消息
     * @return String
     */
    public String getMessage() {
        return message;
    }
}

