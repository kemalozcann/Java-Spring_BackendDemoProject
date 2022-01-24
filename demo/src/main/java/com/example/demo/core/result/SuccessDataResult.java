package com.example.demo.core.result;

public class SuccessDataResult <T> extends DataResult<T>{
    public SuccessDataResult(T data, String message) {
        super(data,message,true);
    }
    public SuccessDataResult(T data, boolean success) {
        super(data,true);
    }
    public SuccessDataResult( String message) {
        super(null,message,true);
    }



}
