package com.github.smartbooks.bootstrap.exception;

/**
 * 自定义异常示例
 */
public class TestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TestException() {
    }

    public TestException(String message) {
        super(message);
    }
}
