package com.se.dao;

import com.se.model.po.StaffPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StaffDao {
    //给员工创造账户时调用
    int save(StaffPO staffPO);
    StaffPO getStaffByName(String name);
    List<StaffPO> getAllStaff();
}
