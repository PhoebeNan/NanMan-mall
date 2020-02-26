package com.zyn.mall.common;

/**
 * 封装了枚举常用API代码
 * @author zhaoyanan
 * @create 2020-02-26-8:57
 */
public enum ResultCode implements ICode {

    SUCCESS(200,"操作成功"),
    FAILURE(500,"操作失败"),
    VALIDATE_FAILURE(404,"参数校验失败"),
    UNAUTHORIZED(401,"暂未登录或token已过期"),
    FORBIDDEN(403,"没有相关权限");

    private long code;
    private String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
