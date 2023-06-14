package com.se.service.staff;

import com.se.dao.StaffDao;
import com.se.model.po.StaffPO;
import com.se.model.vo.StaffVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowInfoServiceImpl implements ShowInfoService{
    private final StaffDao staffDao;

    @Autowired
    public ShowInfoServiceImpl(StaffDao staffDao){
        this.staffDao = staffDao;
    }

    @Override
    public StaffVO showInfo(String name) {
        StaffPO staffPO=staffDao.getStaffByName(name);
        StaffVO staffVO=new StaffVO();
        BeanUtils.copyProperties(staffPO,staffVO);
        return staffVO;
    }
}
