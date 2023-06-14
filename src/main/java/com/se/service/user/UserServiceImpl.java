package com.se.service.user;

import com.auth0.jwt.interfaces.Claim;
import com.se.config.JwtConfig;
import com.se.dao.UserDao;
import com.se.enums.Role;
import com.se.model.po.User;
import com.se.model.vo.UserVO;
import com.se.exception.MyServiceException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        User user = userDao.findByUsernameAndPassword(userVO.getName(), userVO.getPassword());
        if (null == user ) {
            throw new MyServiceException("A0000", "用户名或密码错误");
        }
        Map<String, String> authToken = new HashMap<>();
        String token = jwtConfig.createJWT(user);
        authToken.put("token", token);
        return authToken;
    }

    @Override
    public void register(UserVO userVO) {
        User user = userDao.findByUsername(userVO.getName());
        if (user != null) {
            throw new MyServiceException("A0001", "用户名已存在");
        }
        User userSave = new User();
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


    @Override
    public void editPw(String name, String oldPw, String newPw){
        String old=userDao.findPwByUsername(name);
        System.out.println(old);
        System.out.println(oldPw);
        if(old.equals(oldPw)){
            System.out.println("12331313131");
            userDao.updateUser(name,newPw);
        }else{
            throw new MyServiceException("E0001", "旧密码错误");
        }
    }
}
