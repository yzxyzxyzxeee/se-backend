package com.se.dao;

import com.se.model.po.PerformancePO;
import com.se.model.po.StaffPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PerformanceDao {
    PerformancePO findByName(String name);

    int save(PerformancePO performancePO);

    List<PerformancePO> findAll();
}
