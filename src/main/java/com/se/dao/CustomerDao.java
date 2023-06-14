package com.se.dao;

import com.se.enums.CustomerType;
import com.se.model.po.CustomerPO;
import com.se.model.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CustomerDao {
    int updateOne(CustomerPO customerPO);

    CustomerPO findOneById(Integer supplier);

    List<CustomerPO> findAllByType(CustomerType customerType);

    CustomerPO findOneByName(String name);

    List<CustomerPO> findAll();

    List<User> findAllUser();
}
