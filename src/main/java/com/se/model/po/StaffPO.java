package com.se.model.po;

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
public class StaffPO {
    //相比VO，多加了个打卡
    private String name;

    private String birth;
    private String phoneNumber;

    private Role job;

    private String password;
}
