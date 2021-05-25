package com.base.aop.response;

import lombok.Getter;

@Getter
public enum ResponseStatus {

    SUCCESS(0),
    FAIL(1);

    private Integer status;

    ResponseStatus(Integer status) {
        this.status = status;
    }

}