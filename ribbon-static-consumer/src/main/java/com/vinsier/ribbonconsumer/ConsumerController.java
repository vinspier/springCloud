package com.vinsier.ribbonconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    // 向已经注册的服务提供者 获取服务(hello接口服务)
    @RequestMapping ("/helloConsumer")
    public String helloConsumer() {
        // 采用访问服务名的方式获取对应服务接口功能 hello-service服务
        return restTemplate.getForEntity("http://hello-service/hello",String.class).getBody();
    }

}
