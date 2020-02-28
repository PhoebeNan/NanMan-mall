package com.zyn.mall.common;

import lombok.Data;

/**
 * 封装返回代码，信息，数据的对象
 *
 * @author zhaoyanan
 * @create 2020-02-26-10:07
 */
@Data
public class CommonResult<T> {

    private long code; //返回代码
    private String message;//返回信息
    private T data;

    public CommonResult() {
    }


    public CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回的结果
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回的结果
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(String message, T data) {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回的结果
     *
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failure() {
        return new CommonResult<T>(ResultCode.FAILURE.getCode(), ResultCode.FAILURE.getMessage(), null);
    }

    /**
     * 失败返回的结果
     *
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failure(String message,T data) {
        return new CommonResult<T>(ResultCode.FAILURE.getCode(), message, data);
    }

    /**
     * 失败返回的结果
     *
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failure(String message) {
        return new CommonResult<T>(ResultCode.FAILURE.getCode(), message, null);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> CommonResult<T> validateFailed(T data) {
        return new CommonResult<T>(ResultCode.VALIDATE_FAILURE.getCode(), ResultCode.VALIDATE_FAILURE.getMessage(), data);
    }

    /**
     * 未登录返回结果
     */
    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }
}
