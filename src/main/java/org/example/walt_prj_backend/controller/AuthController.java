package org.example.walt_prj_backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.walt_prj_backend.pojo.dto.UserDTO;
import org.example.walt_prj_backend.pojo.vo.LoginVO;
import org.example.walt_prj_backend.service.AuthService;
import org.example.walt_prj_backend.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Tag(name = "权限管理模块")
public class AuthController {

    @Autowired
    AuthService authService;

    @Operation(summary = "欢迎接口")
    public String welcome(){
        return "Hello,World";
    }

    @Operation(summary = "登录接口")
    @PostMapping("/login")
    public ResponseMessage<LoginVO> login(@RequestBody UserDTO.UserLoginDto userLoginDto) {
        LoginVO loginVO = authService.login(userLoginDto);
        return loginVO != null ? ResponseMessage.success(loginVO) : ResponseMessage.error("用户名或密码错误");
    }

    @Operation(summary = "注册接口")
    @PostMapping("/register")
    public ResponseMessage<LoginVO> register(@RequestBody UserDTO.UserAddDto userAddDto) {
        LoginVO loginVO = authService.register(userAddDto);
        return loginVO != null ? ResponseMessage.success(loginVO) : ResponseMessage.error("注册失败，用户名可能已存在");
    }
}
