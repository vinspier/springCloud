package com.vinspier.serviceapi.service;

import com.vinspier.serviceapi.dto.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 定义接口标准 供服务端和客户端规范统一调用
 * 简化 客户端与服务端接口的相同而冗余编写
 */
@RequestMapping(value = "/refactor")
public interface HelloService {

    @RequestMapping(value = "/hello4")
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello5")
    String hello(@RequestHeader("id") Integer id, @RequestHeader("name") String name);

    @RequestMapping(value = "/hello6")
    String hello(@RequestBody User user);

}
