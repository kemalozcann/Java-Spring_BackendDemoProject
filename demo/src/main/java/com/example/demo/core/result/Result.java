package com.example.demo.core.result;

public class Result {
    private boolean success;
    private String message;

    public Result(boolean success)
    {
    this.success=success;
    }
    public Result(String message,boolean success){
    this(success);
    this.message=message;

    }

    public boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
