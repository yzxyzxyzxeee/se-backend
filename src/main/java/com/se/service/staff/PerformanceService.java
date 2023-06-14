package com.se.service.staff;

import com.se.model.po.PerformancePO;
import com.se.model.vo.PerformanceVO;

import java.util.List;

public interface PerformanceService {
    void writeIn(PerformanceVO performanceVO);

    List<PerformancePO> readOut();

    PerformancePO readOutByName(String name);

}
