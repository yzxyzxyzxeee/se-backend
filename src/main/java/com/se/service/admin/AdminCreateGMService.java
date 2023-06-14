package com.se.service.admin;


import com.se.model.vo.StaffVO;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public interface AdminCreateGMService {
    //注册
    void register(StaffVO staffVO) throws ParseException;

    void registerAll(List<StaffVO> staffVOList) throws ParseException;

    List<StaffVO> getAllStaff();
}
