package com.vinspier.eurekaservice.controller;

import com.vinspier.serviceapi.dto.User;
import com.vinspier.serviceapi.service.HelloService;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通过实现api接口的方式 达到客户端和服务端接口的统一应用和规范
 * 消除代码冗余
 */
@RestController
public class RefactorHelloController implements HelloService {

    @Override
    public String hello(String name) {
        return "method hello4:--- and msg:{ name:" + name + " }";
    }

    @Override
    public String hello(Integer id, String name) {
        return "method hello5:--- and msg:{ id:" + id +" ,name:" + name + " }";
    }

    @Override
    public String hello(User user) {
        return "method hello3:--- and msg: " + user.toString();
    }
}
