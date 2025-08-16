package org.example.walt_prj_backend.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@Tag(name = "用户管理")
public class UserController {


    @GetMapping("/welcome")
    @Operation(summary = "欢迎信息")
    public String welcome(){
        return "Hello World";
    }



}