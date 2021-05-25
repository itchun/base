package com.base.controller;

import com.base.aop.exception.ExceptionCustom;
import com.base.aop.response.ResponseBody;
import com.base.model.DemoModel;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController {

    @RequestMapping("demoException1")
    public String demoException1() {
        return Integer.valueOf("sss").toString();
    }

    @RequestMapping("demoException2")
    public String demoException2(@Validated DemoModel demoModel) {
        return Integer.valueOf("sss").toString();
    }

    @RequestMapping("demoException3")
    public void demoException3() throws ExceptionCustom {
        throw new ExceptionCustom("这是自定义异常");
    }

    @RequestMapping(value = "null")
    public String nullStr() {
        return null;
    }

    @RequestMapping(value = "string1")
    public String string1() {
        return "123";
    }

    @RequestMapping(value = "string2", produces = "application/json; charset=UTF-8")
    public String string2() {
        return "123";
    }

    @RequestMapping(value = "string3", produces = "application/json; charset=UTF-8")
    public Object string3() {
        return "123";
    }

    @RequestMapping("int")
    public Object intM() {
        return 123;
    }

    @RequestMapping("DemoModel")
    public Object DemoModel() {
        return new DemoModel();
    }

    @RequestMapping("ResponseBody")
    public ResponseBody ResponseBody() {
        return null;
    }
}
