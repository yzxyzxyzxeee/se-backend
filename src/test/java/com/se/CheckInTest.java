package com.se;

import com.se.dao.CheckInDao;
import com.se.enums.Role;
import com.se.model.vo.StaffVO;
import com.se.service.admin.AdminCreateGMService;
import com.se.service.staff.CheckInService;
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
public class CheckInTest {
    //该测试检验打卡功能
    @Autowired
    CheckInDao checkInDao;
    @Autowired
    CheckInService checkInService;
    @Autowired
    AdminCreateGMService adminCreateGMService;

    @SneakyThrows
    @Test
    @Transactional
    @Rollback(value = true)
    public void test1() {
        //先创建一个员工账号用于测试
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
        //以下是打卡测试
       checkInService.checkIn("yy");
       Calendar calendar=Calendar.getInstance();
       int year= calendar.get(Calendar.YEAR);
       int month= calendar.get(Calendar.MONTH)+1;
       int day= calendar.get(Calendar.DAY_OF_MONTH);
       Assertions.assertEquals(checkInDao.ifCheckIn("yy",year,month,day),1);
       Assertions.assertEquals(checkInDao.ifCheckIn("yy",1999,month,day),0);
       Assertions.assertEquals(checkInDao.totalThisMonth("yy",year,month),1);
       Assertions.assertEquals(checkInDao.totalThisMonth("yy",1999,month),0);
    }

}
