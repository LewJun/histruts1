package com.microandroid.exception;

/**
 * 全局异常
 *
 * @author LewJun
 * @version v0.1 2019/03/14 16:56 LewJun Exp $$
 */
public class GlobalException extends RuntimeException {
    public GlobalException() {
    }

    public GlobalException(String message) {
        super(message);
    }

    public GlobalException(String message, Throwable cause) {
        super(message, cause);
    }

    public GlobalException(Throwable cause) {
        super(cause);
    }
}
