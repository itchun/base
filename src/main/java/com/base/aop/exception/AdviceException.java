package com.base.aop.exception;

import com.base.aop.response.ResponseBody;
import com.base.aop.response.ResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

// 全局异常处理 请求状态码默认为200
@RestControllerAdvice
public class AdviceException {

    private static final Logger logger = LoggerFactory.getLogger(AdviceException.class);

    // Exception异常处理
    @ExceptionHandler(value = Exception.class)
    public ResponseBody exceptionHandler(Exception e) {
        logger.error(e.getMessage(), e);
        return new ResponseBody(ResponseStatus.FAIL.getStatus(), "系统异常");
    }

    // 接口字段校验@Validated异常处理
    @ExceptionHandler(value = BindException.class)
    public ResponseBody fieldExceptionHandler(BindException e) {
        List<FieldError> fieldErrors = e.getFieldErrors();
        List<String> messages = new ArrayList<>(fieldErrors.size());
        if (fieldErrors != null && fieldErrors.size() > 0) {
            for (int i = 0; i < fieldErrors.size(); i++) {
                messages.add(fieldErrors.get(i).getDefaultMessage());
            }
        }
        return new ResponseBody(ResponseStatus.FAIL.getStatus(), messages);
    }

    // 业务层自定义返回错误数据
    @ExceptionHandler(value = ExceptionCustom.class)
    public ResponseBody serviceExceptionHandler(ExceptionCustom e) {
        return new ResponseBody(e.getStatus(), e.getMessage());
    }

}
