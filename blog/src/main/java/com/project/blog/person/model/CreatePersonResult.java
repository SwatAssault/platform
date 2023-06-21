package com.project.blog.person.model;

public class CreatePersonResult {
    private boolean success;

    public CreatePersonResult(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
