package com.se.dao;

import com.se.enums.State;
import com.se.model.po.PromotionPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface PromotionDao {


    int save(PromotionPO toSave);


    PromotionPO findById(String id);


    List<PromotionPO> findByState(State state);


    int updateState(String id, State state);



}
