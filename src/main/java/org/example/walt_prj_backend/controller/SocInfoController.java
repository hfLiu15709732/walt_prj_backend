package org.example.walt_prj_backend.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.example.walt_prj_backend.pojo.dto.SocInfoDTO;
import org.example.walt_prj_backend.pojo.entity.SocInfo;
import org.example.walt_prj_backend.service.SocInfoService;
import org.example.walt_prj_backend.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SOC芯片信息前端控制器
 */
@Slf4j
@RestController
@RequestMapping("/socinfo")
@Tag(name = "SOC芯片信息模块")
public class SocInfoController {

    @Autowired
    private SocInfoService socInfoService;

    /**
     * 添加SOC芯片信息
     */
    @PostMapping
    @Operation(summary = "添加信息")
    public ResponseMessage<Boolean> addSocInfo(@RequestBody SocInfo socInfo) {
        boolean success = socInfoService.save(socInfo);
        return success ? ResponseMessage.success("添加成功", true) : ResponseMessage.error("添加失败");
    }

    /**
     * 根据ID删除SOC芯片信息
     */
    @Operation(summary = "删除信息")
    @DeleteMapping("/{id}")
    public ResponseMessage<Boolean> deleteSocInfo(@PathVariable Integer id) {
        boolean success = socInfoService.removeById(id);
        return success ? ResponseMessage.success("删除成功", true) : ResponseMessage.error("删除失败");
    }

    /**
     * 更新SOC芯片信息
     */
    @PutMapping
    @Operation(summary = "修改信息")
    public ResponseMessage<Boolean> updateSocInfo(@RequestBody SocInfo socInfo) {
        boolean success = socInfoService.updateById(socInfo);
        return success ? ResponseMessage.success("更新成功", true) : ResponseMessage.error("更新失败");
    }

    /**
     * 根据ID查询SOC芯片信息
     */
    @GetMapping("/{id}")
    @Operation(summary = "单一查询")
    public ResponseMessage<SocInfo> getSocInfoById(@PathVariable Integer id) {
        SocInfo socInfo = socInfoService.getById(id);
        return socInfo != null ? ResponseMessage.success("查询成功", socInfo) : ResponseMessage.error(404, "未找到该SOC芯片信息");
    }


    /**
     * 分页查询SOC芯片信息
     */
    @GetMapping("/page")
    @Operation(summary = "分页查询SOC芯片")
    public ResponseMessage<Page<SocInfo>> getSocInfoPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                                         @RequestParam(defaultValue = "10") Integer pageSize) {
        Page<SocInfo> page = new Page<>(pageNum, pageSize);
        Page<SocInfo> socInfoPage = socInfoService.page(page);
        List<SocInfo> socInfoPageRecords = socInfoPage.getRecords();
        log.info(socInfoPageRecords.toString());
        return ResponseMessage.success("分页查询成功", page);
    }


    /**
     * 条件查询 SOC 列表（POST + Body）
     */
    @PostMapping("/list")
    @Operation(summary = "条件查询")
    public ResponseMessage<List<SocInfo>> listSocInfosByCondition(
            @RequestBody SocInfoDTO.SocQueryDto queryDto) {
        List<SocInfo> list = socInfoService.listByCondition(queryDto);
        return ResponseMessage.success("查询成功", list);
    }


    /**
     * 条件分页查询 SOC 芯片信息
     */
    @PostMapping("/page")
    @Operation(summary = "条件查询（支持分页）")
    public ResponseMessage<Page<SocInfo>> pageSocInfos(
            @RequestBody @Validated SocInfoDTO.SocPageQueryDto dto) {
        Page<SocInfo> page = socInfoService.pageByCondition(dto);
        return ResponseMessage.success("分页查询成功", page);
    }
}