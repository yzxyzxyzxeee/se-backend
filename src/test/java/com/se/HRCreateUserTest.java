package com.se;

import com.se.dao.StaffDao;
import com.se.enums.Role;
import com.se.model.vo.StaffVO;
import com.se.service.admin.AdminCreateGMService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class HRCreateUserTest {
    // 该测试查看HR是否可以为员工建立账户

    @Autowired
    StaffDao staffDao;

    @Autowired
    AdminCreateGMService adminCreateGMService;

    @SneakyThrows
    @Test
    @Transactional
    @Rollback(value = true)
    public void create() {
        String str="2000-12-27";
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(str);
        StaffVO staffVO = StaffVO.builder()
                .name("yy")
                .birth(date)
                .phoneNumber("123321")
                .job(Role.STAFF)
                .password("123456")
                .build();
        adminCreateGMService.register(staffVO);
        List<StaffVO> staffVOList = adminCreateGMService.getAllStaff();
        Assertions.assertEquals("yy", staffVOList.get(0).getName());
    }

}