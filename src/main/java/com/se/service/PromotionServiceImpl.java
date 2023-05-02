package com.se.service;

import com.se.dao.PromotionDao;
import com.se.enums.State;
import com.se.model.po.PromotionPO;
import com.se.model.vo.PromotionVO;
import com.se.model.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {

    private final PromotionDao promotionDao;

    @Autowired
    public PromotionServiceImpl(PromotionDao promotionDao) {
        this.promotionDao = promotionDao;
    }

    @Override
    @Transactional
    public void makePromotion(UserVO userVO, PromotionVO promotionVO) {
        PromotionPO promotionPO = new PromotionPO();
        BeanUtils.copyProperties(promotionVO, promotionPO);
        promotionPO.setOperator(userVO.getName());
        promotionPO.setState(State.PENDING);

        promotionDao.save(promotionPO);
    }

    @Override
    @Transactional
    public void approval(String promotionId, State state) {
        if (state.equals(State.FAILURE)) {//目标状态: 审批失败
            if (promotionDao.findById(promotionId).getState().equals(State.PENDING))
                throw new RuntimeException("success");
            if (promotionDao.findById(promotionId).getState().equals(State.SUCCESS))
                throw new RuntimeException("该单据为审批成功单据");
            if (promotionDao.findById(promotionId).getState().equals(State.FAILURE))
                throw new RuntimeException("该单据已经为审批失败单据");
            //update
            int is_update = promotionDao.updateState(promotionId, state);
            if (is_update == 0) throw new RuntimeException("状态更新失败, 无匹配订单");
        } else if (state.equals(State.PENDING)) {//目标状态: 待审批状态
            if (promotionDao.findById(promotionId).getState().equals(State.PENDING))
                throw new RuntimeException("已经是待审批状态");
            if (promotionDao.findById(promotionId).getState().equals(State.FAILURE))
                throw new RuntimeException("该单据为审批失败单据");
            if (promotionDao.findById(promotionId).getState().equals(State.SUCCESS))
                throw new RuntimeException("该单据为审批成功单据");
        } else if (state.equals(State.SUCCESS)) {//目标状态: 审批成功
            if (promotionDao.findById(promotionId).getState().equals(State.SUCCESS))
                throw new RuntimeException("已经是审批成功状态");
            if (promotionDao.findById(promotionId).getState().equals(State.PENDING)) {
                //update
                int is_update = promotionDao.updateState(promotionId, state);
                if (is_update == 0) throw new RuntimeException("状态更新失败, 无匹配订单");
            }
        }
    }

    @Override
    @Transactional
    public List<PromotionVO> getByState(State state) {
        List<PromotionPO> promotionPOS = promotionDao.findByState(state);
        List<PromotionVO> promotionVOS = new ArrayList<>();
        for (PromotionPO po : promotionPOS) {
            PromotionVO vo = new PromotionVO();
            BeanUtils.copyProperties(po, vo);
            promotionVOS.add(vo);
        }
        return promotionVOS;
    }
}
