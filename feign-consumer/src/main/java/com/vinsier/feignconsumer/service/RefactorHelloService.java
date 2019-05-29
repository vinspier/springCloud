package com.vinsier.feignconsumer.service;

import com.vinspier.serviceapi.service.HelloService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * 通过实现api接口的方式 达到客户端和服务端接口的统一应用和规范
 * 消除代码冗余
 */
@FeignClient("hello-service")
public interface RefactorHelloService extends HelloService{

}
