package com.helix.practice.demo2.controller;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

class ExceptionResponse
{
    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

@ControllerAdvice
public class ErrorHandlingController {
    @ExceptionHandler({NoSuchElementException.class,EmptyResultDataAccessException.class})
    public ResponseEntity<ExceptionResponse> generalException(Exception ex) {
        ExceptionResponse er = new ExceptionResponse();
        er.setCode(HttpStatus.NOT_FOUND.value());
        er.setDesc(ex.getMessage());
        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
    }
}

