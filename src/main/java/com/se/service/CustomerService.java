package com.se.service;

import com.se.enums.CustomerType;
import com.se.model.po.CustomerPO;
import com.se.model.po.UserPO;

import java.util.List;

public interface CustomerService {
    /**
     * 根据id更新客户信息
     * @param customerPO 客户信息
     */
    void updateCustomer(CustomerPO customerPO);

    /**
     * 根据type查找对应类型的客户
     * @param type 客户类型
     * @return 客户列表
     */
    List<CustomerPO> getCustomersByType(CustomerType type);

    List<CustomerPO> findAll();

    List<UserPO> findAllUser();

    CustomerPO findCustomerById(Integer supplier);

    CustomerPO findCustomerByName(String name);
}
