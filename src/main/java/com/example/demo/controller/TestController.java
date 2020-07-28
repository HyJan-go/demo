package com.example.demo.controller;

import com.example.demo.datasource.test.entity.User;
import com.example.demo.datasource.test.service.IUserService;
import com.example.demo.entity.Teacher;
import com.example.demo.enums.TencentApiCostTypeEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: demo
 * @description: 测试使用
 * @author: HyJan
 * @create: 2020-04-28 16:53
 **/
@RestController
public class TestController {

    @Autowired
    private IUserService userService;

    @GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Teacher> getTeacherList() {
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher(12345, "黎明", 26));
        teachers.add(new Teacher(123456, "黎明2", 29));
        teachers.add(new Teacher(123457, "黎明3", 28));
        teachers.add(new Teacher(123458, "黎明5", 27));
        return teachers;
    }

    @GetMapping(value = "lists", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUserList() {
        return userService.getUsers();
    }

    @GetMapping("/enum")
    @ResponseBody
    public Map getEnums(){
        return TencentApiCostTypeEnums.getMap();
    }
}
