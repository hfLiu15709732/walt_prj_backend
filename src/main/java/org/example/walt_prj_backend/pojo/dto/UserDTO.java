package org.example.walt_prj_backend.pojo.dto;

import lombok.Data;

@Data
public class UserDTO {
    private int id;
    private String username;
    private String password;
    private String email;

    // 用于新增用户的 DTO
    @Data
    public static class UserAddDto {
        private String username;
        private String password;
        private String email;
    }

    // 用于更新用户的 DTO
    @Data
    public static class UserUpdateDto {
        private int id;
        private String username;
        private String password;
        private String email;
    }

    // 用于查询用户的 DTO
    @Data
    public static class UserQueryDto {
        private Integer id;
        private String username;
        private String email;
    }

    // 用于删除用户的 DTO
    @Data
    public static class UserDeleteDto {
        private int id;
    }

    // 用于登录用户的 DTO
    @Data
    public static class UserLoginDto {
        private String username;
        private String password;
    }
}