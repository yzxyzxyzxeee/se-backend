package com.se.dao;

import com.se.model.po.CheckInPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CheckInDao {
    //查看是否有打卡，用来防止重复打卡
    int ifCheckIn(String name,int year,int month,int day);
    //记录打卡
    int checkIn(String name,int year,int month,int day,int hour,int minute,int second);

    List<CheckInPO>findAll();
    //获取本月打卡信息，
    int totalThisMonth(String name,int year,int month);
    //修改stuff表的checkIn记录
    //void updateCheckIn(String name);
}
