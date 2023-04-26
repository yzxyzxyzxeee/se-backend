package com.se.service;


import com.se.model.vo.CustomerVO;

public interface CustomerManageService {
    void register(CustomerVO customerVO);
    void delete(int id);

    void update(CustomerVO customerVO);
}
