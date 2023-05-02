package com.se.controller;

import com.se.auth.Authorized;
import com.se.enums.Role;
import com.se.enums.State;
import com.se.model.vo.PromotionVO;
import com.se.model.vo.UserVO;
import com.se.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/promotion")
public class PromotionController {
    private final PromotionService promotionService;

    @Autowired
    public PromotionController(PromotionService promotionService){this.promotionService=promotionService;}

    @Authorized(roles = {Role.SALE_STAFF, Role.ADMIN})
    @PostMapping(value="/promotion-make")
    public Response makePromotion(UserVO userVO, PromotionVO promotionVO){
        promotionService.makePromotion(userVO,promotionVO);
        return Response.buildSuccess();
    }

    @GetMapping(value = "/approval")
    @Authorized (roles = { Role.SALE_MANAGER,Role.GM, Role.ADMIN})
    public Response approval(@RequestParam("id") String id,
                                  @RequestParam("state") State state)  {
        if(state.equals(State.FAILURE) || state.equals(State.PENDING)) {
            promotionService.approval(id, state);
            return Response.buildSuccess();
        } else {
            return Response.buildFailed("000000","操作失败"); // code可能得改一个其他的
        }
    }

    @GetMapping(value = "/get-show")
    public Response showSheetByState(@RequestParam(value = "state", required = false) State state)  {
        return Response.buildSuccess(promotionService.getByState(state));
    }
}
