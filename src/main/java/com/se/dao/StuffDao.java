package com.se.dao;

import com.se.model.po.CustomerPO;
import com.se.model.po.StuffPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StuffDao {
    //HR给员工创造账户时调用
    int save(StuffPO stuffPO);
    StuffPO getStuffByName(String name);
    List<StuffPO> getAllStuff();
    int delete(String name);

}
