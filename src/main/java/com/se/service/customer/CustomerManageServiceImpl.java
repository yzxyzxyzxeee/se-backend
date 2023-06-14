package com.se.service.customer;

import com.se.dao.CustomerDao;
import com.se.dao.CustomerManageDao;
import com.se.model.po.CustomerPO;
import com.se.model.vo.CustomerVO;
import com.se.exception.MyServiceException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerManageServiceImpl implements CustomerManageService {
    private final CustomerManageDao customerManageDao;
    private final CustomerDao customerDao;
    @Autowired
    public CustomerManageServiceImpl(CustomerManageDao customerManageDao,CustomerDao customerDao) {
        this.customerManageDao = customerManageDao;
        this.customerDao=customerDao;
    }
    @Override
    public void register(CustomerVO customerVO) {
        CustomerPO customerPO = customerDao.findOneById(customerVO.getId());
        if(customerPO!=null){
            throw new MyServiceException("A0001", "客户已存在");
        }
        CustomerPO customerPOSave=new CustomerPO();
        BeanUtils.copyProperties(customerVO,customerPOSave);
        customerManageDao.create(customerPOSave);
    }

    @Override
    public void delete(int id) {
        CustomerPO customerPO= customerDao.findOneById(id);

        if (customerPO == null) {
            throw new MyServiceException("B0004", "删除失败！");
        }

        int ans = customerManageDao.delete(id);
        if (ans == 0) {
            throw new MyServiceException("B0004", "删除失败！");
        }

    }

    @Override
    public void update(CustomerVO customerVO) {
        CustomerPO customerPO = customerDao.findOneById(customerVO.getId());
        if(customerPO==null){
            throw new MyServiceException("C0001", "客户不存在");
        }
        CustomerPO customerPOSave=new CustomerPO();
        BeanUtils.copyProperties(customerVO,customerPOSave);
        customerManageDao.update(customerPOSave);
    }


}
