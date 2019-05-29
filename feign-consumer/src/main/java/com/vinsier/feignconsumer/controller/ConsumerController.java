package com.vinsier.feignconsumer.controller;

import com.vinsier.feignconsumer.service.HelloService;
import com.vinsier.feignconsumer.service.RefactorHelloService;
import com.vinspier.serviceapi.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private RefactorHelloService refactorHelloService;

    // 通过service向已经注册的服务提供者 获取服务(hello接口服务)
    @RequestMapping ("/hello")
    public String helloConsumer() {
        return helloService.hello();
    }

    @RequestMapping ("/hello1")
    public String helloConsumer1() {
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello1(100,"fxb1")).append("\n");
        sb.append(helloService.hello2(200,"fxb2")).append("\n");
        sb.append(helloService.hello3(new com.vinsier.feignconsumer.entity.User(300,"fxb3"))).append("\n");
        return sb.toString();
    }

    @RequestMapping ("/hello2")
    public String helloConsumer2() {
        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloService.hello("fxb1")).append("\n");
        sb.append(refactorHelloService.hello(200,"fxb2")).append("\n");
        sb.append(refactorHelloService.hello(new User(300,"fxb3"))).append("\n");
        return sb.toString();
    }
}
