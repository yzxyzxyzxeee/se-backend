package com.se;


import com.se.dao.StuffDao;
import com.se.enums.Gender;
import com.se.enums.Role;
import com.se.model.vo.StuffVO;
import com.se.service.HRCreateUserService;
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
    StuffDao stuffDao;

    @Autowired
    HRCreateUserService hrCreateUserService;

    @SneakyThrows
    @Test
    @Transactional
    @Rollback(value = true)
    public void create() {
        String str="2000-12-27";
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(str);
        StuffVO stuffVO = StuffVO.builder()
                .name("keke")
                .realName("keke")
                .gender(Gender.male)
                .birth(date)
                .phoneNumber("123321")
                .baseSalary(BigDecimal.valueOf(321))
                .job(Role.HR)
                .jobSalary(BigDecimal.valueOf(123))
                .jobLevel(1)
                .salaryCalculateWay(1)
                .password("123456")
                .build();
        hrCreateUserService.register(stuffVO);
        List<StuffVO> stuffVOList= hrCreateUserService.getAllStuff();
        Assertions.assertEquals(1,stuffVOList.size());
        Assertions.assertEquals("keke",stuffVOList.get(0).getName());
        Assertions.assertEquals(Role.HR,stuffVOList.get(0).getJob());
    }

}