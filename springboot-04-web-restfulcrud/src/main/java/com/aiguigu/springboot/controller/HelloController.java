package com.aiguigu.springboot.controller;

import com.aiguigu.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HelloController {
    @Autowired
    private User user;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
       // System.out.println(user);
       /* user.getMaps().forEach((k,v) ->
            System.out.println("userKey: "+k+" userValue: "+v)
        );*/
        System.out.println("热部署");
        return "Hello world";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        //map.put("hello","你好");
        return "success";
    }

//    @RequestMapping({"/", "/index.html"})
//    public String index(){
//        return "index";
//    }
}
