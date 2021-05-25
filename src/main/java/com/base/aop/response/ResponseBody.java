package com.base.aop.response;

import lombok.Data;

@Data
public class ResponseBody {

    private Integer status;
    private Object data;

    public ResponseBody(Integer status, Object data) {
        this.status = status;
        this.data = data;
    }
}
