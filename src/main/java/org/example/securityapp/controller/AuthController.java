package org.example.securityapp.controller;

import lombok.RequiredArgsConstructor;
import org.example.securityapp._core.Resp;
import org.example.securityapp.controller.dto.UserRequest;
import org.example.securityapp.domain.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * username=ssar&password=1234&email=ssar@nate.com
 * { "username":"ssar", "password":"1234", "email":"ssar@nate.com" }
 */

@RequiredArgsConstructor
@RestController
public class AuthController {
    private final UserService userService;

    @PostMapping("/join")
    public Resp<?> join(@RequestBody UserRequest.Join reqDTO) {
        userService.회원가입(reqDTO);
        return new Resp<>();
    }

    @PostMapping("/login")
    public Resp<?> login(@RequestBody UserRequest.Login reqDTO) {
        String accessToken = userService.로그인(reqDTO);
        return new Resp<>(accessToken);
    }
}






