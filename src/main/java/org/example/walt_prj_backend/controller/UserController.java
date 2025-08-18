package org.example.walt_prj_backend.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.walt_prj_backend.pojo.entity.SocInfo;
import org.example.walt_prj_backend.pojo.entity.User;
import org.example.walt_prj_backend.service.SocInfoService;
import org.example.walt_prj_backend.service.UserService;
import org.example.walt_prj_backend.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
@Tag(name = "用户管理模块")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加用户信息
     */
    @PostMapping
    @Operation(summary = "添加用户信息")
    public ResponseMessage<Boolean> addSocInfo(@RequestBody User userInfo) {
        boolean success = userService.save(userInfo);
        return success ? ResponseMessage.success("添加成功", true) : ResponseMessage.error("添加失败");
    }

    /**
     * 根据ID删除用户信息
     */
    @Operation(summary = "删除用户")
    @DeleteMapping("/{id}")
    public ResponseMessage<Boolean> deleteSocInfo(@PathVariable Integer id) {
        boolean success = userService.removeById(id);
        return success ? ResponseMessage.success("删除成功", true) : ResponseMessage.error("删除失败");
    }

    /**
     * 更新用户信息
     */
    @PutMapping
    @Operation(summary = "修改用户")
    public ResponseMessage<Boolean> updateSocInfo(@RequestBody User userInfo) {
        boolean success = userService.updateById(userInfo);
        return success ? ResponseMessage.success("更新成功", true) : ResponseMessage.error("更新失败");
    }

    /**
     * 根据ID查询用户信息
     */
    @GetMapping("/{id}")
    @Operation(summary = "查询单一用户")
    public ResponseMessage<User> getSocInfoById(@PathVariable Integer id) {
        User userInfo = userService.getById(id);
        return userInfo != null ? ResponseMessage.success("查询成功", userInfo) : ResponseMessage.error(404, "未找到该用户信息");
    }

    /**
     * 查询所有用户信息
     */
    @GetMapping
    @Operation(summary = "查询所有用户")
    public ResponseMessage<List<User>> getAllSocInfos() {
        List<User> userInfos = userService.list();
        return ResponseMessage.success("查询成功", userInfos);
    }



}