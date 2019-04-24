package com.vinspier.hystrix.controller;

import com.vinspier.hystrix.service.HystrixService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HystrixController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    HystrixService hystrixService;


    @RequestMapping(value = "/hystrix-consumer", method = RequestMethod.GET)
    public String hell() {
        return hystrixService.hello();
    }

}
