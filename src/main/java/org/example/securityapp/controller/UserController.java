package org.example.securityapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @GetMapping("/joinform")
    public String joinForm() {
        return "user/join-form";
    }

    @GetMapping("/main")
    public String main() {
        return "user/main";
    }

    @PostMapping("/join")
    public String join(String username, String password, String email) {
        System.out.println(username);
        System.out.println(password);
        System.out.println(email);
        return "redirect:/main";
    }
}






