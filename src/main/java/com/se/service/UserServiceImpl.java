package com.se.service;

import com.auth0.jwt.interfaces.Claim;
import com.se.config.JwtConfig;
import com.se.dao.UserDao;
import com.se.exception.MyServiceException;
import com.se.model.po.UserPO;
import com.se.model.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.se.enums.Role;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private final JwtConfig jwtConfig;

    @Autowired
    public UserServiceImpl(UserDao userDao, JwtConfig jwtConfig) {
        this.userDao = userDao;
        this.jwtConfig = jwtConfig;
    }


    @Override
    public Map<String, String> login(UserVO userVO) {
        UserPO userPO = userDao.findByUsernameAndPassword(userVO.getName(), userVO.getPassword());
        if (null == userPO ) {
            throw new MyServiceException("A0000", "用户名或密码错误");
        }
        Map<String, String> authToken = new HashMap<>();
        String token = jwtConfig.createJWT(userPO);
        authToken.put("token", token);
        return authToken;
    }

    @Override
    public void register(UserVO userVO) {
        UserPO userPO = userDao.findByUsername(userVO.getName());
        if (userPO != null) {
            throw new MyServiceException("A0001", "用户名已存在");
        }
        UserPO userSave = new UserPO();
        BeanUtils.copyProperties(userVO, userSave);
        userDao.createUser(userSave);
    }

    @Override
    public UserVO auth(String token) {
        Map<String, Claim> claims = jwtConfig.parseJwt(token);
        UserVO userVO = UserVO.builder()
                .name(claims.get("name").as(String.class))
                .role(Role.valueOf(claims.get("role").as(String.class)))
                .build();
        return userVO;
    }
}
