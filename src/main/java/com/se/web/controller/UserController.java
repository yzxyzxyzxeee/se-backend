package com.se.web.controller;

import com.se.config.JwtConfig;
import com.se.dao.UserDao;
import com.se.model.vo.UserVO;
import com.se.service.UserService;
import com.se.web.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {


    private final UserDao userDao;

    private JwtConfig jwtConfig;

    private UserService userService;

    @Autowired
    public UserController(UserDao userDao, JwtConfig jwtConfig, UserService userService) {
        this.userDao = userDao;
        this.jwtConfig = jwtConfig;
        this.userService = userService;
    }

    @PostMapping("/login")
    public Response userLogin(@RequestBody UserVO userVO) {

        return Response.buildSuccess(userService.login(userVO));
    }

    @PostMapping("/register")
    public Response userRegister(@RequestBody UserVO userVO) {
        userService.register(userVO);
        return Response.buildSuccess();
    }

    @GetMapping("/auth")
    public Response userAuth(@RequestParam(name = "token") String token) {
        return Response.buildSuccess(userService.auth(token));
    }
}

