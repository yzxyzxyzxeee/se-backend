package com.se.controller;


import com.se.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        checkInService.checkIn(name);
        return Response.buildSuccess();
    }
}
