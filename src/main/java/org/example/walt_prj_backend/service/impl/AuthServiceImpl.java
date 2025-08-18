package org.example.walt_prj_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.example.walt_prj_backend.mapper.UserMapper;
import org.example.walt_prj_backend.pojo.dto.UserDTO;
import org.example.walt_prj_backend.pojo.entity.User;
import org.example.walt_prj_backend.pojo.vo.LoginVO;
import org.example.walt_prj_backend.service.AuthService;
import org.example.walt_prj_backend.utils.JwtUtil;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserMapper userMapper;

    @Override
    public LoginVO login(UserDTO.UserLoginDto userLoginDto) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userLoginDto.getUsername());
        User user = userMapper.selectOne(queryWrapper);

        if (user == null || !user.getPassword().equals(JwtUtil.md5(userLoginDto.getPassword()))) {
            return null; // 登录失败
        }

        String token = JwtUtil.generateToken(user);
        return new LoginVO(token, convertToDTO(user));
    }

    @Override
    public LoginVO register(UserDTO.UserAddDto userAddDto) {
        // 检查用户名是否已存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userAddDto.getUsername());
        if (userMapper.selectCount(queryWrapper) > 0) {
            return null; // 用户名已存在
        }

        User user = new User();
        user.setUsername(userAddDto.getUsername());
        user.setPassword(JwtUtil.md5(userAddDto.getPassword())); // 密码加密
        user.setEmail(userAddDto.getEmail());

        if (userMapper.insert(user) > 0) {
            String token = JwtUtil.generateToken(user);
            return new LoginVO(token, convertToDTO(user));
        }
        return null; // 注册失败
    }

    private UserDTO convertToDTO(User user) {
        if (user == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());

        return userDTO;
    }

}
