package com.se.web.controller;

import com.se.auth.Authorized;
import com.se.enums.Role;
import com.se.model.vo.PerformanceVO;
import com.se.service.staff.PerformanceService;
import com.se.web.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/performance")
public class PerformanceController {
    private final PerformanceService performanceService;

    @Autowired
    public PerformanceController(PerformanceService performanceService){this.performanceService=performanceService;}

    @PostMapping("/save")
    @Authorized(roles={Role.GM})
    public Response save(@RequestBody PerformanceVO performanceVO){
        performanceService.writeIn(performanceVO);
        return Response.buildSuccess();
    }

    @GetMapping("/findByName")
    public Response findByName(@RequestParam String name){
        return Response.buildSuccess(performanceService.readOutByName(name));
    }

    @GetMapping("/findAll")
    public Response findAll(){
        return Response.buildSuccess(performanceService.readOut());
    }
}
