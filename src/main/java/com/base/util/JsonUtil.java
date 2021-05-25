package com.base.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JsonUtil {

    public static final SerializerFeature[] FEATURE = {SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.DisableCircularReferenceDetect};

    public static String toJson(Object o) {
        return JSON.toJSONString(o, FEATURE);
    }

}
