package com.test.checkedAndUncheckException;

public class Client {
    public static void main(String[] args) {

    }

    public void check() throws Exception {
        throw new MyCheckedException("1", "2");
    }

    public void uncheck() {
        throw new MyUncheckedException("1","2");
    }
}
