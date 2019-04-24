package com.vinspier.eurekaservice;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping ("/hello")
    public String hello() throws Exception{
        ServiceInstance instance = client.getLocalServiceInstance();
        // 模拟服务熔断 hystirx默认超时时间为2000ms
        int sleepTime = new Random().nextInt(1000);
        logger.info("thread sleeping " + sleepTime + "time");
        Thread.sleep(sleepTime);
        logger.info("/hello, host: " + instance.getHost() + ", server_id: " + instance.getServiceId());
        return "hello world";
    }

    @RequestMapping ("json")
    public Map json() {
        Map<String,Object> map = new HashMap<>();
        map.put("1","1234");
        map.put("2","2345y");
        return map;
    }


}
