package com.example.demo.datasource.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.datasource.test.entity.User;
import com.example.demo.datasource.test.mapper.UserMapper;
import com.example.demo.datasource.test.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HyJan
 * @since 2020-04-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        List<User> users = userMapper.selectList(new QueryWrapper<User>());
        return users;
    }
}
