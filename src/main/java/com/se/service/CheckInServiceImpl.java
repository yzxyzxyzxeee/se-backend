package com.se.service;

import com.se.dao.CheckInDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

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
        //如果今天已打卡，则无视该请求
        if(checkInDao.ifCheckIn(name,year,month,day)==1){
        }else{
            //修改checklog表的记录
            checkInDao.checkIn(name,year,month,day);
            //修改stuff表的记录
            checkInDao.updateCheckIn(name);
        }
    }
}

