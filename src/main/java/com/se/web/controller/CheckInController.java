package com.se.web.controller;


import com.alibaba.fastjson.JSONObject;
import com.se.auth.Authorized;
import com.se.enums.Role;
import com.se.service.staff.CheckInService;
import com.se.web.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/checkIn")
public class CheckInController {
    private final CheckInService checkInService;

    @Autowired
    public CheckInController(CheckInService checkInService) {
        this.checkInService=checkInService;
    }

    @PostMapping("/checkIn")
    //只需要提供该操作用户的name（用户名）即可
    public Response checkIn(@RequestBody String name) {
        System.out.println(name);
        System.out.println("11111111111111111111");
        JSONObject json = JSONObject.parseObject(name);
        String str=String.valueOf(json.get("name"));
        checkInService.checkIn(str);
        return Response.buildSuccess();
    }

    @GetMapping("/getCheckIn")
    @Authorized(roles = {Role.ADMIN, Role.GM})
    public Response getCheckIn(){
        System.out.println(1111);
        return Response.buildSuccess(checkInService.getCheckIn());
    }
}
