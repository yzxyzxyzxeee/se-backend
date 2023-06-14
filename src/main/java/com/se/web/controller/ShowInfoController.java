package com.se.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.se.service.staff.ShowInfoService;
import com.se.web.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/staff")
public class ShowInfoController {
    private final ShowInfoService showInfoService;

    @Autowired
    public ShowInfoController(ShowInfoService showInfoService){this.showInfoService=showInfoService;}

    @PostMapping("/showInfo")
    public Response showInfo(@RequestBody String name){
        System.out.println(name);
        JSONObject json = JSONObject.parseObject(name);
        System.out.println(json);
        String name1=String.valueOf(json.get("name"));
        System.out.println("1111");
        return Response.buildSuccess(showInfoService.showInfo(name1));}

}
