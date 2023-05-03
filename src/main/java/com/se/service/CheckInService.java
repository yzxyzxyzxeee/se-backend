package com.se.service;

import com.se.model.vo.CheckInVO;

import java.util.List;

public interface CheckInService {
    void checkIn(String name);

    List<CheckInVO> getCheckIn();
}
