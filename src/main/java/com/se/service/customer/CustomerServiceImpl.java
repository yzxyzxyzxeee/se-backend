package com.se.service.customer;

import com.se.dao.CustomerDao;
import com.se.enums.CustomerType;
import com.se.model.po.CustomerPO;
import com.se.model.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    /**
     * 根据id更新客户信息
     *
     * @param customerPO 客户信息
     */
    @Override
    public void updateCustomer(CustomerPO customerPO) {
        customerDao.updateOne(customerPO);
    }

    /**
     * 根据type查找对应类型的客户
     *
     * @param type 客户类型
     * @return 客户列表
     */
    @Override
    public List<CustomerPO> getCustomersByType(CustomerType type) {

        return customerDao.findAllByType(type);
    }

    @Override
    public CustomerPO findCustomerById(Integer supplier) {
        return customerDao.findOneById(supplier);
    }

    @Override
    public CustomerPO findCustomerByName(String name) {
        return customerDao.findOneByName(name);
    }
    int updateOne(CustomerPO customerPO){return 0;}

    CustomerPO findOneById(Integer supplier){

        return new CustomerPO();
    }

    List<CustomerPO> findAllByType(CustomerType customerType){return new ArrayList<>();}
    public List<CustomerPO> findAll(){
        return customerDao.findAll();
    }

    public List<User> findAllUser(){
        return customerDao.findAllUser();
    }

}
