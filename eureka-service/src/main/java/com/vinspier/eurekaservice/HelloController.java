package com.vinspier.eurekaservice;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping ("/hello")
    public String hello(){
        ServiceInstance instance = client.getLocalServiceInstance();
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
