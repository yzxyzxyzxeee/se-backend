package com.se.web.controller;

import com.se.auth.Authorized;
import com.se.web.Response;
import com.se.enums.Role;
import com.se.model.vo.StaffVO;
import com.se.service.admin.AdminCreateGMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(path = "/admin-create-GM")
public class AdminCreateGMController {
    private final AdminCreateGMService adminCreateGMService;
    @Autowired
    public AdminCreateGMController(AdminCreateGMService adminCreateGMService){
        this.adminCreateGMService = adminCreateGMService;
    }

    @Authorized(roles = {Role.ADMIN})
    @PostMapping(value = "/create")
    public Response createNewUser(@RequestBody StaffVO staffVO) throws ParseException {
        adminCreateGMService.register(staffVO);
        return Response.buildSuccess();
    }

    @Authorized(roles = {Role.ADMIN})
    @PostMapping(value = "/createAll")
    public Response createNewUserAll(@RequestBody List<StaffVO> staffVOList) throws ParseException {
        adminCreateGMService.registerAll(staffVOList);
        return Response.buildSuccess();
    }

    @Authorized(roles = {Role.ADMIN})
    @PostMapping(value = "/showAll")
    public Response getAllStuff() {
        return Response.buildSuccess(adminCreateGMService.getAllStaff());
    }

}
