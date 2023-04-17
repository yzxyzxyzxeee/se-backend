package com.se.dao;

import com.se.model.po.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {

    UserPO findByUsernameAndPassword(String username, String password);

    int createUser(UserPO user);

    UserPO findByUsername(String username);
}
