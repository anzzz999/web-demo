package com.mengan.webdemo.service.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mengan.webdemo.bean.User;
import com.mengan.webdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService  {
    @Autowired
    private UserMapper userMapper;

    public List<User> getUsers() {
        return userMapper.getUsers();
    }

    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public List<User> getUserByName(String userName) {
        List<User> users = userMapper.getUserByName(userName);
        System.out.println("从数据库中读取，而非从缓存读取!");
        return users;
    }

    @Override
    public void updateUser() {

        int pageSize = 1;
        int totalPage = 0;
        Integer count = userMapper.selectCount(new LambdaQueryWrapper<>());
        totalPage = count / pageSize;
        if (count % pageSize != 0) {
            totalPage++;
        }
        Page<User> userPage = new Page<>();
        userPage.setSize(pageSize);
        while (totalPage > 0) {
            userPage.setCurrent(totalPage--);
            IPage<User> page = userMapper.selectPage(userPage, new LambdaQueryWrapper<>());
            List<User> needUpdateUser = new ArrayList<>();
            for (User user : page.getRecords()) {
                if (user.getId() % 2 == 0) {
                    needUpdateUser.add(user);
                }
            }
            System.out.println(needUpdateUser);
        }


    }
}