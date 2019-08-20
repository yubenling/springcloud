package com.example.loginservice.entity;

/*
 *@create yubenling
 *@date  2019/8/19
 *@desc  */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable {

    private Integer id;
    private String name;
    private Integer age;
}
