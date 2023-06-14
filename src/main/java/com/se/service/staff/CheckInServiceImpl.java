package com.se.service.staff;

import com.se.dao.CheckInDao;
import com.se.model.po.CheckInPO;
import com.se.model.vo.CheckInVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class CheckInServiceImpl implements CheckInService {
    private final CheckInDao checkInDao;
    @Autowired
    public CheckInServiceImpl(CheckInDao checkInDao) {
        this.checkInDao = checkInDao;
    }

    @Override
    public void checkIn(String name) {
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+1;
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        int hour=calendar.get(Calendar.HOUR_OF_DAY);
        int minute=calendar.get(Calendar.MINUTE);
        int second=calendar.get(Calendar.SECOND);
        System.out.println(hour);
        System.out.println(minute);
        System.out.println(second);
        //如果今天已打卡，则无视该请求
        if(checkInDao.ifCheckIn(name,year,month,day)!=0){
        }else{
            //修改checklog表的记录
            checkInDao.checkIn(name,year,month,day,hour,minute,second);
        }
    }

    @Override
    public List<CheckInVO> getCheckIn() {
        List<CheckInPO> all = checkInDao.findAll();
        List<CheckInVO> res = new ArrayList<>();
        for(CheckInPO checkInPO : all) {
            CheckInVO vo = new CheckInVO();
            BeanUtils.copyProperties(checkInPO, vo);
            res.add(vo);
            System.out.println(vo);
        }
        return res;
    }
}
