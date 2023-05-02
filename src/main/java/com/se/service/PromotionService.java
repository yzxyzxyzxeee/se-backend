package com.se.service;

import com.se.enums.State;
import com.se.model.vo.PromotionVO;
import com.se.model.vo.UserVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PromotionService {
    void makePromotion(UserVO userVO, PromotionVO promotionVO);

    void approval(String promotionId, State state);

    List<PromotionVO> getByState(State state);

}
