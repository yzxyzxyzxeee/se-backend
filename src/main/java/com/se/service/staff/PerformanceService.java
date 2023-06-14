package com.se.service.staff;

import com.se.model.po.PerformancePO;
import com.se.model.vo.PerformanceVO;

import java.util.List;

public interface PerformanceService {
    void writeIn(List<PerformanceVO> performanceVOList);

    List<PerformancePO> readOut(int month);

    PerformancePO readOutByName(String name,int month);

}
