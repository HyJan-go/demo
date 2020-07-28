package com.example.demo.datasource.test.service;

import com.example.demo.datasource.test.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HyJan
 * @since 2020-04-28
 */
public interface IUserService extends IService<User> {
    List<User> getUsers();
}
