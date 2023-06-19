package com.project.platfrom.base.http;

import org.springframework.http.HttpStatus;

public class Payload<T> {
    private final T responseObject;
    private final int status;
    private final String failureMessage;

    public Payload(T responseObject) {
        this.responseObject = responseObject;
        this.status = HttpStatus.OK.value();
        this.failureMessage = null;
    }

    public Payload(String failureMessage, int status) {
        this.responseObject = null;
        this.failureMessage = failureMessage;
        this.status = status;
    }

    public T getResponseObject() {
        return responseObject;
    }

    public int getStatus() {
        return status;
    }

    public String getFailureMessage() {
        return failureMessage;
    }
}