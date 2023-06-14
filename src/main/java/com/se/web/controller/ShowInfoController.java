package com.se.web.controller;

import com.se.service.staff.ShowInfoService;
import com.se.web.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/staff")
public class ShowInfoController {
    private final ShowInfoService showInfoService;

    @Autowired
    public ShowInfoController(ShowInfoService showInfoService){this.showInfoService=showInfoService;}

    @GetMapping("/showInfo")
    public Response showInfo(@RequestParam String name){return Response.buildSuccess(showInfoService.showInfo(name));}

}
