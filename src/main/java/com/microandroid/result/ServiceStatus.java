package com.microandroid.result;

/**
 * <pre>
 * {
 * "code": 0,
 * "msg": "请求成功"
 * }
 *
 * {
 * "code": 0,
 * "msg": "请求成功",
 * "data": 数字/文字
 * }
 *
 * {
 * "code": 0,
 * "msg": "请求成功",
 * "data": {对象}
 * }
 *
 * {
 * "code": 0,
 * "msg": "请求成功",
 * "data": [{列表}]
 * }</pre>
 *
 * @author LewJun
 * @version v0.1 2018/08/15 09:18 LewJun Exp $$
 */
public enum ServiceStatus {

    /**
     * 系统异常（尽量不要抛这个异常）
     */
    EXCEPTION(-1, "系统繁忙"),

    /**
     * 请求失败
     */
    FAILED(-2, "请求失败"),

    /**
     * 非法请求
     */
    INVALID(-3, "非法请求"),

    /**
     * 请求成功
     */
    SUCCESS(0, "请求成功");

    /**
     * 状态码
     */
    private int code;

    /**
     * 描述信息
     */
    private String msg;

    /**
     * 构造方法
     *
     * @param code 状态码
     * @param msg  描述信息
     */
    ServiceStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "ServiceStatus{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}