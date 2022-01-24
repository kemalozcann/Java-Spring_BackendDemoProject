package com.example.demo.core.result;

public class SuccessResult extends Result{

    public SuccessResult(){
        super(true);
    }
    public SuccessResult(String message){
        super(message,true);
    }
}
