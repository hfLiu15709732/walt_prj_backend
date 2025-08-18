package org.example.walt_prj_backend.service;

import org.example.walt_prj_backend.pojo.dto.UserDTO;
import org.example.walt_prj_backend.pojo.vo.LoginVO;

public interface AuthService {
    LoginVO login(UserDTO.UserLoginDto userLoginDto);

    LoginVO register(UserDTO.UserAddDto userAddDto);
}
