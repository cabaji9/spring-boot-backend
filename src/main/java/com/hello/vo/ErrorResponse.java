package com.hello.vo;

import java.io.Serializable;

public class ErrorResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;
    private Object parameterWithError;

    public ErrorResponse() {
        super();
    }

    public ErrorResponse(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public Object getParameterWithError() {
        return parameterWithError;
    }

    public void setParameterWithError(Object parameterWithError) {
        this.parameterWithError = parameterWithError;
    }



    @Override
    public String toString() {
        return "ErrorResponse [message=" + message  + ", parameterWithError=" + parameterWithError
                + "]";
    }

}
