package com.mengan.webdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mengan.webdemo.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from tbl_user")
    List<User> getUsers();

    @Insert("insert into tbl_user values(#{name},#{age})")
    int addUser(User user);

    @Select("select * from tbl_user where name=#{userName}")
    List<User> getUserByName(String userName);
}
