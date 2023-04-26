package com.se.controller;


import com.se.auth.Authorized;
import com.se.enums.CustomerType;
import com.se.enums.Role;
import com.se.model.po.CustomerPO;
import com.se.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/findByType")
    public Response findByType(@RequestParam CustomerType type) {
        return Response.buildSuccess(customerService.getCustomersByType(type));
    }

    @PostMapping("/update")
    @Authorized(roles = {Role.FINANCIAL_STAFF,Role.ADMIN, Role.SALE_STAFF,Role.SALE_MANAGER,Role.GM})
    public Response customerUpdate(@RequestBody CustomerPO customerPO) {
        customerService.updateCustomer(customerPO);
        return Response.buildSuccess();
    }

    @GetMapping("/findAll")
    @Authorized(roles = {Role.FINANCIAL_STAFF,Role.ADMIN, Role.SALE_STAFF,Role.SALE_MANAGER,Role.GM})
    public Response findAll() {
        return Response.buildSuccess(customerService.findAll());
    }

    @GetMapping("/findAllUser")
    @Authorized(roles = {Role.FINANCIAL_STAFF,Role.ADMIN, Role.SALE_STAFF,Role.SALE_MANAGER,Role.GM})
    public Response findAllUser() {
        return Response.buildSuccess(customerService.findAllUser());
    }


}
