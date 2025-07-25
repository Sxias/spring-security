package org.example.securityapp.controller;

import org.example.securityapp._core.Resp;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/admin")
@RestController
public class AdminController {

    @GetMapping
    public Resp<?> adminMain() {
        return new Resp<>();
    }
}
