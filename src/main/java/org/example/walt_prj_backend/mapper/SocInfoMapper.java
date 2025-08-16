package org.example.walt_prj_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.walt_prj_backend.pojo.entity.SocInfo;

@Mapper
public interface SocInfoMapper extends BaseMapper<SocInfo> {
    // MyBatis-Plus 提供了基本的CRUD方法，无需额外定义
}
