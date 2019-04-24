package com.vinspier.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HystrixService {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    RestTemplate restTemplate;

    // 当访问的服务 不在正常提供服务时 回调自定义的回调方法
    @HystrixCommand(fallbackMethod = "callBack",commandKey = "helloKey")
    public String hello() {
        long start = System.currentTimeMillis();
        /*
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        long end = System.currentTimeMillis();
        logger.info("consumer-time:   " + (end - start) + "ms");
        return restTemplate.getForEntity("http://hello-service/hello",String.class).getBody();
    }


    public String callBack() {
        logger.info("hello-service has broken up !");
        return "error";
    }

}
