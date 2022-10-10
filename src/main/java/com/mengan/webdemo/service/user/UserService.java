package com.mengan.webdemo.service.user;

import com.mengan.webdemo.bean.User;

import java.util.List;

/**
 * @Author: zhanmingwei
 */
public interface UserService {

     List<User> getUserByName(String userName);

    void updateUser();
}
