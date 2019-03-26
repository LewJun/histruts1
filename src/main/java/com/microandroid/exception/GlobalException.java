package com.microandroid.exception;

import com.microandroid.result.ApiResult;
import com.microandroid.result.ServiceStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author LewJun
 * @version v0.1 2018/08/15 09:16 LewJun Exp $$
 */
public class GlobalException extends RuntimeException {
    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalException.class);

    private ApiResult result;


    public GlobalException(Throwable cause) {
        this(ServiceStatus.EXCEPTION, null, null, cause);
    }

    public GlobalException(String message) {
        this(message, null);
    }

    public GlobalException(String message, Throwable cause) {
        setResult(new ApiResult(message));
        LOGGER.error("【message={}, cause={}】", message, cause);
    }

    public GlobalException(ServiceStatus status, Object content, String message) {
        this(status, content, message, null);
    }

    public GlobalException(ServiceStatus status) {
        this(status, null, null);
    }

    public GlobalException(ServiceStatus status, Throwable ex) {
        this(status, null, null, ex);
    }

    /**
     * 构造器
     */
    public GlobalException(ServiceStatus status, Object content, String message, Throwable cause) {
        super(message, cause);
        setResult(new ApiResult(status, content));
        LOGGER.error("【status={}, content={}, message={}, cause={}】", status, content, message, cause);
    }

    public ApiResult getResult() {
        return result;
    }

    private void setResult(ApiResult result) {
        this.result = result;
    }
}
