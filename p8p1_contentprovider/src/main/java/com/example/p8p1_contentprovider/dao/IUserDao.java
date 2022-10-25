package com.example.p8p1_contentprovider.dao;

import com.example.p8p1_contentprovider.pojo.User;

import java.util.List;

/**
 * @项目名称：MingriApplication
 * @包名：com.example.p8p1_contentprovider.dao
 * @作者：FENG
 * @类名：IUserDao
 * @创建时间：2022/9/413:10
 * @描述：数据库接口层
 **/
public interface IUserDao {
    //增加用户
    long addUser(User user);
    //删除用户
    int deleteUserById(int id);
    //修改用户
    int updateUser(User user);
    //通过ID查询某个User
    User getUserById(int id);
    //查询全部用户
    List<User> listAllUser();
}
