package com.se.service;


import com.se.model.vo.StuffVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HRCreateUserService {
    //注册
    void register(StuffVO stuffVO);

    List<StuffVO> getAllStuff();
}
