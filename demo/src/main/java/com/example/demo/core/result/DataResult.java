package com.example.demo.core.result;

public class DataResult<T> extends Result{
    private T data;

    public DataResult(T data, String message, boolean success) {
        super(message, success);
        this.data=data;
    }
    public DataResult(T data,boolean success) {
        super(success);
        this.data=data;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
