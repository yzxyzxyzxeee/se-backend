package com.se.dao;


import com.se.model.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {

    User findByUsernameAndPassword(String username, String password);

    int createUser(User user);

    User findByUsername(String username);

    int editPw(String oldPw,String newPw);

    int updateUser(String name,String newPw);

    String findPwByUsername(String name);
}
