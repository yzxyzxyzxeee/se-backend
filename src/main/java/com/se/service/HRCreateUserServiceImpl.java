package com.se.service;

import com.se.config.JwtConfig;
import com.se.dao.StuffDao;
import com.se.dao.UserDao;
import com.se.model.po.StuffPO;
import com.se.model.vo.StuffVO;
import com.se.model.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class HRCreateUserServiceImpl implements HRCreateUserService {
    private final StuffDao stuffDao;
    private final UserDao userDao;
    private final JwtConfig jwtConfig;

    @Autowired
    public HRCreateUserServiceImpl(StuffDao stuffDao, UserDao userDao, JwtConfig jwtConfig){
        this.stuffDao =stuffDao;
        this.userDao=userDao;
        this.jwtConfig=jwtConfig;
    }
    //注册
    @Override
    @Transactional
    public void register(StuffVO stuffVO){
        System.out.println(stuffVO.getJob());
        //注册账号
        UserService userService=new UserServiceImpl(userDao,jwtConfig);
        UserVO userVO=new UserVO();
        userVO.setName(stuffVO.getName());
        userVO.setPassword(stuffVO.getPassword());
        userVO.setRole(stuffVO.getJob());

        userService.register(userVO);
        StuffPO stuffPO=new StuffPO();
        BeanUtils.copyProperties(stuffVO, stuffPO);

        stuffDao.save(stuffPO);
    }

    @Override
    public List<StuffVO> getAllStuff() {
        List<StuffPO> stuffPOS= stuffDao.getAllStuff();
        List<StuffVO> res=new ArrayList<>();
        for (StuffPO spo:stuffPOS) {
            StuffVO stuffVO=new StuffVO();
            BeanUtils.copyProperties(spo,stuffVO);
            res.add(stuffVO);
        }
        return res;
    }

}
