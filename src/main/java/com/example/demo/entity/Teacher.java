package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: demo
 * @description: 教师实体类
 * @author: HyJan
 * @create: 2020-04-28 16:54
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    private Integer number;
    private String name;
    private Integer age;
}
