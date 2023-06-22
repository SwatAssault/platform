package com.project.blog.person.model;

public class CreatePersonResult {
    private boolean success;
    private String errorMessage;

    public CreatePersonResult(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
