package com.cn.hbu.hive.service.impl;

import com.cn.hbu.hive.dao.UserDao;
import com.cn.hbu.hive.domain.User;
import com.cn.hbu.hive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> selectAllUser() {
        List<User> users = userDao.selectAllUser();
        return users;
    }
}
