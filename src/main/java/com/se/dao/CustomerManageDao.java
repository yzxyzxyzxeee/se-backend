package com.se.dao;

import com.se.model.po.CustomerPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CustomerManageDao {
    int create(CustomerPO customerPO);
    int delete(int id);

    int update(CustomerPO customerPO);
}
