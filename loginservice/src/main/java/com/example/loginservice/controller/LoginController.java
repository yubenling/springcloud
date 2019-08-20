package com.example.loginservice.controller;

import com.example.loginservice.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/*
 *@create yubenling
 *@date  2019/8/19
 *@desc  */
@RestController
@Slf4j
public class LoginController {
    /**
     * get请求传递参数
     * @return
     */
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public User getUser(@RequestParam("name") String name,@RequestParam("age") Integer age){
        log.info("通过get方式传递参数name={},age={}",name,age);
        return new User(1,name,age);
    }

    /**
     * 通过post方式传递参数
     */
    @RequestMapping(value = "/postUser",method = RequestMethod.POST)
    public User postUser(@RequestBody User user){
       log.info("传递的参数为"+user);
       return  user;
    }

}
