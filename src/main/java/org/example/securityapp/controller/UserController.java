package org.example.securityapp.controller;

import org.example.securityapp._core.Resp;
import org.example.securityapp.domain.user.User;
import org.example.securityapp.domain.user.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Resp<?> user() {
        return new Resp<>();
    }
}






