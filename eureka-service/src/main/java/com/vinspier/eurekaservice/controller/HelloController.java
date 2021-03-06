package com.vinspier.eurekaservice.controller;

import com.vinspier.eurekaservice.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
public class HelloController{

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping ("/hello")
    public String hello() throws Exception{
        ServiceInstance instance = client.getLocalServiceInstance();
        // 模拟服务熔断 hystirx默认超时时间为2000ms
        int sleepTime = new Random().nextInt(3000);
        logger.info("thread sleeping " + sleepTime + "time");
        Thread.sleep(sleepTime);
        logger.info("/hello, host: " + instance.getHost() + ", server_id: " + instance.getServiceId());
        return "hello world";
    }

    /*************************不同形式的参数绑定***********************************/
    @RequestMapping(value = "/hello1")
    String hello1(@RequestParam Integer id, @RequestParam String name){
        return "method hello1:--- and msg:{ id:" + id +" ,name:" + name + " }";
    }

    @RequestMapping(value = "/hello2")
    String hello2(@RequestHeader Integer id, @RequestHeader String name){
        return "method hello2:--- and msg:{ id:" + id +" ,name:" + name + " }";
    }

    @RequestMapping(value = "/hello3")
    String hello3(@RequestBody User user){
        return "method hello3:--- and msg: " + user.toString();
    }
    /************************************************************/

    @RequestMapping ("json")
    public Map json() {
        Map<String,Object> map = new HashMap<>();
        map.put("1","1234");
        map.put("2","2345y");
        return map;
    }

    @RequestMapping("/service/{applicationName}")
    public List<ServiceInstance> getServiceInstance(@PathVariable String applicationName){
        return client.getInstances(applicationName);
    }
}
