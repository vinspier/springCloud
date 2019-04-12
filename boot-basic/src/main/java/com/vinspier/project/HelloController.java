package com.vinspier.project;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    @RequestMapping ("/hello")
    public String hello(){
        return "hello world";
    }

    @RequestMapping ("json")
    public Map json() {
        Map<String,Object> map = new HashMap<>();
        map.put("1","1234");
        map.put("2","2345y");
        return map;
    }

    @RequestMapping ("/list")
    public List list() {
        List list = new ArrayList();
        list.add("123");
        list.add("1234");
        list.add("fdsfe");
        list.add(json());
        return list;
    }

    @RequestMapping ("/book")
    public Book book() {
        Book book = new Book();
        return book;
    }

}
