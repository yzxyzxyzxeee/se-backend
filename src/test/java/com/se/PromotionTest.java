package com.se;

import com.se.dao.PromotionDao;
import com.se.enums.Role;
import com.se.enums.State;
import com.se.model.vo.PromotionVO;
import com.se.model.vo.UserVO;
import com.se.service.PromotionService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class PromotionTest {

    @Autowired
    PromotionDao promotionDao;

    @Autowired
    PromotionService promotionService;

    @SneakyThrows
    @Test
    @Transactional
    @Rollback(value = true)
    public void test11(){
        PromotionVO promotionVO=PromotionVO.builder()
                .id("1")
                .state(State.PENDING)
                .operator("sky")
                .type("100-5")
                .build();
        UserVO userVO=UserVO.builder()
                .name("yyyyzx")
                .role(Role.SALE_MANAGER)
                .password("123456")
                .build();
        promotionService.makePromotion(userVO,promotionVO);

//测试promotion创建功能
//        List<PromotionVO> promotionVOS=promotionService.getByState(State.PENDING);
//        Assertions.assertEquals(1,promotionVOS.size());

        //测试审批功能
        promotionService.approval(promotionVO.getId(),State.SUCCESS);
        List<PromotionVO> promotionVOS=promotionService.getByState(State.SUCCESS);
        Assertions.assertEquals(1,promotionVOS.size());

    }
}
