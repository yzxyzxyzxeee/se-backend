package com.se.model.vo;

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
public class StaffVO {
    //name对应UserVO的用户名，realName是这个员工的真名
    private String name;

    private Date birth;
    private String phoneNumber;

    private Role job;

    private String password;
}
