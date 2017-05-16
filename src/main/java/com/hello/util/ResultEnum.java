package com.hello.util;

/**
 * Created by User on 5/15/17.
 */
public enum ResultEnum {


    OK("ok"),FAIL("fail");


    ResultEnum(String value){
        this.value = value;
    };

    private String value;

    public String getValue() {
        return value;
    }
}
