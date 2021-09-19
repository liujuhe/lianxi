package com.cn.hbu.hive.dao;

import com.cn.hbu.hive.domain.User;

import java.util.List;

public interface UserDao {
    List<User> selectAllUser();
}
