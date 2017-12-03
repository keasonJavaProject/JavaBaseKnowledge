package com.gy.checkedAndUncheckException;

/**
 * Exception 是受检测异常
 */
public class MyCheckedException extends Exception {
    private String msg;

    public MyCheckedException(String message, String msg) {
        super(message);
        this.msg = msg;
    }
}
