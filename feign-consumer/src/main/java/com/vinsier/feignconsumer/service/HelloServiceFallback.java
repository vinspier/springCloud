package com.vinsier.feignconsumer.service;

import com.vinsier.feignconsumer.entity.User;
import org.springframework.stereotype.Component;

/**
 * 服务降级 采用接口实现的方式
 * 在上级接口中定义即可
 * */

@Component
public class HelloServiceFallback implements HelloService {
    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello1(Integer id, String name) {
        return "error";
    }

    @Override
    public String hello2(Integer id, String name) {
        return "error";
    }

    @Override
    public String hello3(User user) {
        return new User(0,"未知").toString();
    }
}
