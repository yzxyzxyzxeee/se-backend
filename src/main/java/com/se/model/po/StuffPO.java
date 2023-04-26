package com.se.model.po;

import com.se.enums.Gender;
import com.se.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StuffPO {
    //相比VO，多加了个打卡
    private String name;
    private String realName;
    private Gender gender;
    private Date birth;
    private String phoneNumber;
    private BigDecimal baseSalary;
    private Role job;
    private BigDecimal jobSalary;
    private Integer jobLevel;
    private Integer salaryCalculateWay;
    //打卡次数，每个月底用于工资计算，每个月1号自动清零
    private Integer checkIn;
}
