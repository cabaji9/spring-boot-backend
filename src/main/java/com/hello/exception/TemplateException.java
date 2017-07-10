package com.hello.exception;

/**
 * Created by User on 5/25/17.
 */
public class TemplateException extends Exception {

    protected int responseStatusCode;

    public TemplateException(String message){
        super(message);
        this.responseStatusCode = 400;
    }


    public int getResponseStatusCode() {
        return responseStatusCode;
    }


}

