package org.example.walt_prj_backend.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.walt_prj_backend.pojo.dto.SocInfoDTO;
import org.example.walt_prj_backend.pojo.entity.SocInfo;

import java.util.List;

/**
 * SOC芯片信息服务接口
 */
public interface SocInfoService extends IService<SocInfo> {
    /**
     * 根据组合条件查询 SOC 列表
     */
    List<SocInfo> listByCondition(SocInfoDTO.SocQueryDto queryDto);


    /**
     * 分页条件查询
     */
    Page<SocInfo> pageByCondition(SocInfoDTO.SocPageQueryDto dto);

}