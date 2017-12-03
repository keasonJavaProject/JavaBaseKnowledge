package com.gy.checkedAndUncheckException;

/**
 *  Error  都是非检测异常
 */
public class MyUncheckedException extends Error {
    private String code;

    public MyUncheckedException(String message, String code) {
        super(message);
        this.code = code;
    }
}
