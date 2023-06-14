package com.se.web.controller;

import com.se.web.Response;
import com.se.auth.Authorized;
import com.se.enums.CustomerType;
import com.se.enums.Role;
import com.se.model.po.CustomerPO;
import com.se.service.customer.CustomerService;
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
    @Authorized(roles = {Role.ADMIN,Role.GM})
    public Response customerUpdate(@RequestBody CustomerPO customerPO) {
        customerService.updateCustomer(customerPO);
        return Response.buildSuccess();
    }

    @GetMapping("/findAll")
    public Response findAll() {
        return Response.buildSuccess(customerService.findAll());
    }

    @GetMapping("/findAllUser")
    public Response findAllUser() {
        return Response.buildSuccess(customerService.findAllUser());
    }


}
