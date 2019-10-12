package com.makai.mapper;

import com.makai.model.User;

import java.util.List;

public interface DateMapper {
    //查询所有
    List<User> users();
    //获取单个
    User getUserById(int id);
    //添加
    int addUser(User user);
    //删除
    int deleteUserById(int id);
    //更新
    int updateUserById(User user);
}
