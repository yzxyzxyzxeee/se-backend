package com.se;

import com.se.dao.CheckInDao;
import com.se.dao.UserDao;
import com.se.enums.Role;
import com.se.model.vo.StaffVO;
import com.se.model.vo.UserVO;
import com.se.service.admin.AdminCreateGMService;
import com.se.service.staff.CheckInService;
import com.se.service.user.UserService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SpringBootTest
public class EditUserTest{
    @Autowired
    UserDao userDao;
    @Autowired
    UserService userService;

    @SneakyThrows
    @Test
    @Transactional
    @Rollback(value = true)
    public void test1() {
        //先创建一个员工账号用于测试
        String str="2000-12-27";
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(str);
        UserVO userVO = UserVO.builder()
                .name("yy")
                .role(Role.STAFF)
                .password("123456")
                .build();
        userService.register(userVO);
        userService.editPw("yy","123456","root");
        System.out.println("111111111");
        Assertions.assertEquals("root",userDao.findPwByUsername("yy"));
    }
        }
