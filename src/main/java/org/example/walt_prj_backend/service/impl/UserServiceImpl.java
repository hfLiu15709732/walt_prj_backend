package org.example.walt_prj_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.walt_prj_backend.mapper.UserMapper;
import org.example.walt_prj_backend.pojo.entity.User;
import org.example.walt_prj_backend.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户信息服务实现类
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}