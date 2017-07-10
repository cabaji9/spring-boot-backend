package com.hello.exception;


import com.hello.vo.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by User on 5/25/17.
 */

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(TemplateException.class)
    public @ResponseBody ResponseEntity<ErrorResponse> defaultErrorHandler(TemplateException e){

        ErrorResponse errorResp = new ErrorResponse(e.getMessage());
        HttpStatus status = HttpStatus.valueOf(e.getResponseStatusCode());

        logger.trace("defaultErrorHandler|Converting exception=[{}={}] to errorResponse={}, status={}", e.getClass(),
                e.getMessage(), errorResp, status);

        return new ResponseEntity<ErrorResponse>(errorResp,status);
    }
}
