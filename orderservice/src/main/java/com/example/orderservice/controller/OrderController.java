package com.example.orderservice.controller;

import com.example.orderservice.entity.User;
import com.example.orderservice.loginapi.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/*
 *@create yubenling
 *@date  2019/8/19
 *@desc  */
@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoginService loginService;
    /**
     * 自身服务
     * @return
     */
    @RequestMapping("/order")
    public String getOrder(){
        return "order";
    }
    /**
     * 服务之间的调用，通过restTemplate
     */
    @RequestMapping("/loginInfo")
    public String getLoginInfo(){
        String forObject = restTemplate.getForObject("http://login/login", String.class);
        return forObject;
    }

    /**
     * 通过feigin方式来调用服务
     * @return
     */
    @RequestMapping("/getUser")
    public User getUser(){
        return loginService.getLogin("yubenling",25);
    }

    /**
     * Feign通过post方式传递参数
     * @return
     */
    @RequestMapping(value = "/postUser")
    public User postUser(){
        User user=new User(1,"YU",2);
        return loginService.postLogin(user);
    }
}
