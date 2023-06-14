package com.se.service.staff;

import com.se.dao.PerformanceDao;
import com.se.model.po.PerformancePO;
import com.se.model.vo.PerformanceVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceServiceImpl implements PerformanceService{

    private final PerformanceDao performanceDao;

    @Autowired
    public PerformanceServiceImpl(PerformanceDao performanceDao) {
        this.performanceDao = performanceDao;
    }


    @Override
    public void writeIn(PerformanceVO performanceVO) {
        PerformancePO performancePO=new PerformancePO();
        BeanUtils.copyProperties(performanceVO,performancePO);
        performanceDao.save(performancePO);
    }

    @Override
    public List<PerformancePO> readOut() {
        return performanceDao.findAll();
    }

    @Override
    public PerformancePO readOutByName(String name) {
        return performanceDao.findByName(name);
    }

}
