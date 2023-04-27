package com.se;

import com.se.dao.CheckInDao;
import com.se.enums.Gender;
import com.se.enums.Role;
import com.se.model.vo.StuffVO;
import com.se.service.CheckInService;
import com.se.service.HRCreateUserService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    HRCreateUserService hrCreateUserService;

    @SneakyThrows
    @Test
    @Transactional
    @Rollback(value = true)
    public void test1() {
        //先创建一个员工账号用于测试
        String str="2001-11-14";
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(str);
        StuffVO stuffVO = StuffVO.builder()
                .name("yzx")
                .realName("yzx")
                .gender(Gender.male)
                .birth(date)
                .phoneNumber("110")
                .baseSalary(BigDecimal.valueOf(10000))
                .job(Role.HR)
                .jobSalary(BigDecimal.valueOf(5000))
                .jobLevel(1)
                .salaryCalculateWay(1)
                .password("123456")
                .build();
        hrCreateUserService.register(stuffVO);
        //以下是打卡测试
        checkInService.checkIn("yzx");
        Calendar calendar=Calendar.getInstance();
        int year= calendar.get(Calendar.YEAR);
        int month= calendar.get(Calendar.MONTH)+1;
        int day= calendar.get(Calendar.DAY_OF_MONTH);

        Assertions.assertEquals(checkInDao.ifCheckIn("yzx",year,month,day),1);
        Assertions.assertEquals(checkInDao.ifCheckIn("yzx",2000,month,day),0);
        Assertions.assertEquals(checkInDao.totalThisMonth("yzx",year,month),1);
//        Assertions.assertEquals(checkInDao.totalThisMonth("yzx",year,month),0);
    }

}

