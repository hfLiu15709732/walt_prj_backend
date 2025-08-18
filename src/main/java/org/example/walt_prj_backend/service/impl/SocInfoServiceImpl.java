package org.example.walt_prj_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.walt_prj_backend.mapper.SocInfoMapper;
import org.example.walt_prj_backend.pojo.dto.SocInfoDTO;
import org.example.walt_prj_backend.pojo.entity.SocInfo;
import org.example.walt_prj_backend.service.SocInfoService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * SOC芯片信息服务实现类
 */
@Service
public class SocInfoServiceImpl extends ServiceImpl<SocInfoMapper, SocInfo> implements SocInfoService {


    @Override
    public List<SocInfo> listByCondition(SocInfoDTO.SocQueryDto dto) {
        QueryWrapper<SocInfo> wrapper = new QueryWrapper<>();

        if (StringUtils.hasText(dto.getName())) {
            wrapper.like("name", dto.getName());
        }
        if (dto.getBrandId() != null) {
            wrapper.eq("brand_id", dto.getBrandId());
        }
        if (StringUtils.hasText(dto.getManufacturer())) {
            wrapper.like("manufacturer", dto.getManufacturer());
        }

        if ("single".equalsIgnoreCase(dto.getSortBy())) {
            boolean asc = !"desc".equalsIgnoreCase(dto.getOrder());
            wrapper.orderBy(true, asc, "geekbench6_single_core");
        } else if ("multi".equalsIgnoreCase(dto.getSortBy())) {
            boolean asc = !"desc".equalsIgnoreCase(dto.getOrder());
            wrapper.orderBy(true, asc, "geekbench6_multi_core");
        }

        return this.list(wrapper);
    }


    @Override
    public Page<SocInfo> pageByCondition(SocInfoDTO.SocPageQueryDto dto) {
        Page<SocInfo> page = new Page<>(dto.getPageNum(), dto.getPageSize());
        QueryWrapper<SocInfo> wrapper = new QueryWrapper<>();

        wrapper.like(StringUtils.hasText(dto.getName()), "name", dto.getName())
                .like(StringUtils.hasText(dto.getManufacturer()), "manufacturer", dto.getManufacturer())
                .eq(dto.getBrandId() != null, "brand_id", dto.getBrandId());

        if ("single".equalsIgnoreCase(dto.getSortBy())) {
            wrapper.orderBy(true, !"desc".equalsIgnoreCase(dto.getOrder()), "geekbench6_single_core");
        } else if ("multi".equalsIgnoreCase(dto.getSortBy())) {
            wrapper.orderBy(true, !"desc".equalsIgnoreCase(dto.getOrder()), "geekbench6_multi_core");
        }

        return this.page(page, wrapper);   // 关键：一定要用 page 而不是 list
    }
}