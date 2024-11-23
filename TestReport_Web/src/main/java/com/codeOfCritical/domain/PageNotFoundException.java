package com.codeOfCritical.domain;

public class PageNotFoundException extends RuntimeException {

    public PageNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
