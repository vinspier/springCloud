package com.vinsier.feignconsumer.service;

import com.vinsier.feignconsumer.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 编写与提供服务的服务端接口对应接口
 * 和服务端的提供接口几乎一致 代码冗余
 *
 * 在构建被@FeignClient修饰的服务客户端时，会为此客户端创建一个Feign.Logger实例
 */
@FeignClient(value = "hello-service",fallback = HelloServiceFallback.class)
public interface HelloService {

    @RequestMapping(value = "/hello")
    String hello();

/*************************不同形式的参数绑定***********************************/
    // 前两种接受参数形式 注解部分的指定参数名不可少 否则启动报错
    @RequestMapping(value = "/hello1")
    String hello1(@RequestParam("id") Integer id,@RequestParam("name") String name);

    @RequestMapping(value = "/hello2")
    String hello2(@RequestHeader("id") Integer id, @RequestHeader("name") String name);

    @RequestMapping(value = "/hello3")
    String hello3(@RequestBody User user);
/************************************************************/

}
