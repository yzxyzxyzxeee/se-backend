package com.se.controller;


import com.se.auth.Authorized;
import com.se.enums.Role;
import com.se.model.vo.CustomerVO;
import com.se.service.CustomerManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/CustomerManage")
public class CustomerManageController {

    private final CustomerManageService customerManageService;

    @Autowired
    public CustomerManageController(CustomerManageService customerManageService) {
        this.customerManageService = customerManageService;
    }

    @PostMapping("/register")
    @Authorized(roles = {Role.ADMIN, Role.SALE_STAFF,Role.SALE_MANAGER,Role.GM})
    public Response customerRegister(@RequestBody CustomerVO customerVO) {
        customerManageService.register(customerVO);
        return Response.buildSuccess();
    }

    @DeleteMapping("/delete")
    @Authorized(roles = {Role.ADMIN, Role.SALE_STAFF,Role.SALE_MANAGER,Role.GM})
    public Response customerDelete(@RequestParam Integer id) {
        customerManageService.delete(id);
        return Response.buildSuccess();
    }

    @PostMapping("/update")
    @Authorized(roles = {Role.ADMIN, Role.SALE_STAFF,Role.SALE_MANAGER,Role.GM})
    public Response customerUpdate(@RequestBody CustomerVO customerVO) {
        customerManageService.update(customerVO);
        return Response.buildSuccess();
    }
}
