package com.base.aop.exception;

import com.base.aop.response.ResponseStatus;
import lombok.Data;

@Data
public class ExceptionCustom extends Exception {

    public Integer status;

    public ExceptionCustom(String message) {
        super(message);
        this.status = ResponseStatus.FAIL.getStatus();
    }

    public ExceptionCustom(Integer status, String message) {
        super(message);
        this.status = status;
    }
}
