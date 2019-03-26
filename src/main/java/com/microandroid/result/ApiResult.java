package com.microandroid.result;

import java.util.UUID;

/**
 * 接口返回
 *
 * @author LewJun
 * @version v0.1 2018/08/13 15:03 LewJun Exp $$
 */
public final class ApiResult<T> {
    private int code;

    private String msg;

    private T data;

    private ServiceStatus status;

    private long time = System.currentTimeMillis();

    private UUID uuid = UUID.randomUUID();

    public ApiResult(ServiceStatus status, T data) {
        this(status.getCode(), status.getMsg(), data);
        setStatus(status);
    }

    public ApiResult(String msg) {
        this(ServiceStatus.EXCEPTION.getCode(), msg);
    }

    public ApiResult(ServiceStatus status) {
        this(status, null);
    }

    public static <E> ApiResult<E> returnResult(E e) {
        return new ApiResult<E>(e);
    }

    public ApiResult() {
        this.code = ServiceStatus.SUCCESS.getCode();
        this.msg = ServiceStatus.SUCCESS.getMsg();
    }

    public ApiResult(int code, String msg) {
        this();
        this.code = code;
        this.msg = msg;
    }

    public ApiResult(int code, String msg, T data) {
        this(code, msg);
        this.data = data;
    }

    public ApiResult(T data) {
        this();
        this.data = data;
    }

    public ServiceStatus getStatus() {
        return status;
    }

    private void setStatus(ServiceStatus status) {
        this.status = status;
    }


}
