package com.se.model.vo;


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
public class StuffVO {
    //name对应UserVO的用户名，realName是这个员工的真名
    private String name;
    private String realName;
    private Gender gender;
    private Date birth;
    private String phoneNumber;
    private BigDecimal baseSalary;
    private Role job;
    private BigDecimal jobSalary;
    private Integer jobLevel;
    //salaryCalculateWay
    // 为1时是“库存人员和人力资源人员实行月薪制”
    // 为2时是“销售人员实行基本工资+提成的制度”
    // 为3时是“经理年薪制度”
    private Integer salaryCalculateWay;
    private String password;
}
