package com.numbers.conversion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static com.numbers.conversion.utils.Constants.*;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    Map<String,String> showCustomMessage(Exception e){
        Map<String,String> response = new HashMap<>();
        response.put(STATUS_LABEL, HttpStatus.BAD_REQUEST.name());
        response.put(TIMESTAMP_LABEL, LocalDateTime.now().toString());
        response.put(MESSAGE_LABEL,ERROR_NUMBER_MESSAGE);
        return response;
    }
}
