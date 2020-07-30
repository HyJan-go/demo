package com.example.demo.service;

/**
 * @program: demo
 * @description: 定义一些测试的常量放接口中，这里强烈不建议生产的时候这么干，这个相当于全局了,因为省略了public static final
 * 比较杂的适合放在常量类中
 * 像status，type建议放枚举类中
 * @author: HyJan
 * @create: 2020-07-30 10:10
 **/
public interface IKwaiApi {

    String BAIDU_URL = "http://www.baidu.com";

}
