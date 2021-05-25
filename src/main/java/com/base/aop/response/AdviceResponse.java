package com.base.aop.response;

import com.base.util.JsonUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class AdviceResponse implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        // 响应格式一致直接返回
        if (o instanceof ResponseBody)
            return o;

        // 响应会默认为String格式,当为空或者String时,判断为不需要转换,ResponseBody当成String处理会报错
        if (o == null || o instanceof String)
            return JsonUtil.toJson(new ResponseBody(ResponseStatus.SUCCESS.getStatus(), o));

        // Accept为application/json 统一响应格式
        if (MediaType.APPLICATION_JSON_VALUE.equals(mediaType.getType() + "/" + mediaType.getSubtype()))
            return new ResponseBody(ResponseStatus.SUCCESS.getStatus(), o);

        return o;
    }

}
