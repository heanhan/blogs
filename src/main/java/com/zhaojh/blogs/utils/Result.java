package com.zhaojh.blogs.utils;

import lombok.Data;


/**
 * springboot 统一消息返回体
 */

@Data
public class Result {

    private boolean flag;//请求响应标识  success /false
    private Integer code;// 请求响应编码
    private String message;//响应消息
    private Object data;//返回数据

    /**
     * 无参数构造
     */
    public Result() {
    }

    /**
     * 无数据返回构造
     * @param flag
     * @param code
     * @param message
     */
    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    /**
     * 带参数返回的构造
     * @param flag
     * @param code
     * @param message
     * @param data
     */
    public Result(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
