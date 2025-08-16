package org.example.walt_prj_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.walt_prj_backend.mapper.SocInfoMapper;
import org.example.walt_prj_backend.pojo.entity.SocInfo;
import org.example.walt_prj_backend.service.SocInfoService;
import org.springframework.stereotype.Service;

/**
 * SOC芯片信息服务实现类
 */
@Service
public class SocInfoServiceImpl extends ServiceImpl<SocInfoMapper, SocInfo> implements SocInfoService {

}