package com.example.demo.core.result;


public class ErrorDataResult <T> extends DataResult<T>{
    public ErrorDataResult(T data, String message) {
        super(data,message,false);
    }
    public ErrorDataResult(T data, boolean success) {
        super(data,false);
    }
}
