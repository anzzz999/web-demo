package com.mengan.webdemo.web.utils;

public class ResultHandler {

    /**
     * 成功时生成ResultBean对象
     * @return ResultBean
     */
    public static <T> ResultBean ok() {
        return new ResultBean<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), null);
    }

    /**
     * 成功时生成ResultBean对象
     * @param data 数据
     * @return ResultBean
     */
    public static <T> ResultBean ok(T data) {
        return new ResultBean<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }

    /**
     * 成功时生成ResultBean对象
     * @param data 数据
     * @param message 消息
     * @return ResultBean
     */
    public static <T> ResultBean ok(T data, String message) {
        return new ResultBean<>(ResultEnum.SUCCESS.getCode(), message, data);
    }


    /**
     * 成功时生成ResultBean对象
     * @param message 消息
     * @return ResultBean
     */
    public static <T> ResultBean okMsg(String message) {
        return new ResultBean<>(ResultEnum.SUCCESS.getCode(), message, null);
    }


    /**
     * 失败时生成ResultBean对象
     * @return ResultBean
     */
    public static ResultBean error() {
        return new ResultBean<>(ResultEnum.EXCEPTION.getCode(), "操作失败", null);
    }

    /**
     * 失败时生成ResultBean对象
     * @param error  错误类型
     * @return  ResultBean
     */
    public static ResultBean error(ResultEnum error) {
        return new ResultBean<>(error.getCode(), error.getMessage(), null);
    }

    /**
     * 失败时生成ResultBean对象
     * @param message 消息
     * @return ResultBean
     */
    public static ResultBean error(String message) {
        return new ResultBean<>(ResultEnum.EXCEPTION.getCode(), message, null);
    }
}
