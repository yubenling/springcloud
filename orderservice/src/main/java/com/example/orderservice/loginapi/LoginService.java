package com.example.orderservice.loginapi;

import com.example.orderservice.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*
 *@create yubenling
 *@date  2019/8/19
 *@desc  */
@FeignClient("login")
public interface LoginService {

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public User getLogin(@RequestParam("name") String name, @RequestParam("age") Integer age);

    @RequestMapping(value = "/postUser",method = RequestMethod.POST)
    public User postLogin(@RequestBody User user);
}
