package org.example.walt_prj_backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.walt_prj_backend.pojo.entity.SocInfo;
import org.example.walt_prj_backend.service.SocInfoService;
import org.example.walt_prj_backend.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SOC芯片信息前端控制器
 */
@RestController
@RequestMapping("/socinfo")
@Tag(name = "SOC芯片信息管理")
public class SocInfoController {

    @Autowired
    private SocInfoService socInfoService;

    /**
     * 添加SOC芯片信息
     */
    @PostMapping
    @Operation(summary = "添加SOC芯片信息")
    public ResponseMessage<Boolean> addSocInfo(@RequestBody SocInfo socInfo) {
        boolean success = socInfoService.save(socInfo);
        return success ? ResponseMessage.success("添加成功", true) : ResponseMessage.error("添加失败");
    }

    /**
     * 根据ID删除SOC芯片信息
     */
    @Operation(summary = "删除SOC芯片")
    @DeleteMapping("/{id}")
    public ResponseMessage<Boolean> deleteSocInfo(@PathVariable Integer id) {
        boolean success = socInfoService.removeById(id);
        return success ? ResponseMessage.success("删除成功", true) : ResponseMessage.error("删除失败");
    }

    /**
     * 更新SOC芯片信息
     */
    @PutMapping
    @Operation(summary = "修改SOC芯片")
    public ResponseMessage<Boolean> updateSocInfo(@RequestBody SocInfo socInfo) {
        boolean success = socInfoService.updateById(socInfo);
        return success ? ResponseMessage.success("更新成功", true) : ResponseMessage.error("更新失败");
    }

    /**
     * 根据ID查询SOC芯片信息
     */
    @GetMapping("/{id}")
    @Operation(summary = "查询单一SOC芯片")
    public ResponseMessage<SocInfo> getSocInfoById(@PathVariable Integer id) {
        SocInfo socInfo = socInfoService.getById(id);
        return socInfo != null ? ResponseMessage.success("查询成功", socInfo) : ResponseMessage.error(404, "未找到该SOC芯片信息");
    }

    /**
     * 查询所有SOC芯片信息
     */
    @GetMapping
    @Operation(summary = "查询所有SOC芯片")
    public ResponseMessage<List<SocInfo>> getAllSocInfos() {
        List<SocInfo> socInfos = socInfoService.list();
        return ResponseMessage.success("查询成功", socInfos);
    }

    /**
     * 分页查询SOC芯片信息
     */
    @GetMapping("/page")
    @Operation(summary = "分页查询SOC芯片")
    public ResponseMessage<Page<SocInfo>> getSocInfoPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                                         @RequestParam(defaultValue = "10") Integer pageSize) {
        Page<SocInfo> page = new Page<>(pageNum, pageSize);
        socInfoService.page(page);
        return ResponseMessage.success("分页查询成功", page);
    }

    /**
     * 根据条件查询SOC芯片信息
     */
    @GetMapping("/search")
    @Operation(summary = "条件查询SOC芯片")
    public ResponseMessage<List<SocInfo>> searchSocInfos(@RequestParam(required = false) String name) {
        QueryWrapper<SocInfo> queryWrapper = new QueryWrapper<>();
        if (name != null && !name.isEmpty()) {
            queryWrapper.like("name", name);
        }
        List<SocInfo> socInfos = socInfoService.list(queryWrapper);
        return ResponseMessage.success("查询成功", socInfos);
    }
}