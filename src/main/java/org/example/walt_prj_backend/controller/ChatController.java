package org.example.walt_prj_backend.controller;

/*用于临时测试的controller*/

import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.walt_prj_backend.pojo.entity.Message;
import org.example.walt_prj_backend.utils.ResponseMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/chat")
@Tag(name = "对话接口模块")
public class ChatController {

    // 1. 接收路径参数（Path Variables）
    @GetMapping("/message/{id}")
    public String getMessageById(@PathVariable Long id) {
        return "获取到ID为" + id + "的消息";
    }

    // 2. 接收请求参数（Request Parameters）
    @GetMapping("/search")
    public String searchMessages(
            @RequestParam String keyword,
            @RequestParam(required = false, defaultValue = "10") Integer limit) {
        return "搜索关键词: " + keyword + ", 最多返回" + limit + "条结果";
    }

    // 3. 接收请求体参数（Request Body）
    @PostMapping("/send")
    public String sendMessage(@RequestBody Message message) {
        return "收到消息: " + message.getContext() + ", 发送者: " + message.getTime();
    }

    // 4. 接收表单参数（Form Data）
    @PostMapping("/login")
    public String userLogin(String username, String password) {
        return "登录信息 - 用户名: " + username + ", 密码长度: " + password.length();
    }

    // 5. 接收请求头参数（Request Headers）
    @GetMapping("/auth")
    public String checkAuth(@RequestHeader("Authorization") String token) {
        return "验证令牌: " + token.substring(0, 6) + "***";
    }

    // 6. 接收Cookie参数
    @GetMapping("/session")
    public String getSession(@CookieValue(value = "sessionId", required = false) String sessionId) {
        if (sessionId == null) {
            return "未检测到会话ID";
        }
        return "当前会话ID: " + sessionId;
    }

    // 7. PUT请求 - 更新消息（路径参数+请求体）
    @PutMapping("/message/{id}")
    public String updateMessage(
            @PathVariable int id,
            @RequestBody Message updatedMessage) {
        // 实际应用中会验证路径ID与消息体ID是否一致
        return "已更新ID为" + id + "的消息 - 新内容: " + updatedMessage.getContext() + ", 新时间: " + updatedMessage.getTime();
    }

    // 8. DELETE请求 - 删除消息（路径参数）
    @DeleteMapping("/message/{id}")
    public String deleteMessage(@PathVariable int id) {
        return "已成功删除ID为" + id + "的消息";
    }

    // 9. 接收CSV文件（简化版，仅返回成功信息）
    @PostMapping("/upload-csv")
    public ResponseMessage<String> uploadCsvFile(@RequestParam("file") MultipartFile file) {
        // 基本文件验证
        //validateFile(file);

        // 这里可以添加文件保存逻辑（如果需要）
        // 例如: file.transferTo(new File("保存路径"));

        // 直接返回成功信息，不解析文件内容
        return ResponseMessage.success("文件上传成功",
                "已接收文件: " + file.getOriginalFilename() +
                        ", 大小: " + file.getSize() + " bytes");
    }

    // 10. 图片上传接口（仅校验并返回基本信息）
    @PostMapping("/upload-image")
    public ResponseMessage<String> uploadImage(@RequestParam("image") MultipartFile imageFile) {
        // 验证图片文件
        //validateImageFile(imageFile);

        // 返回成功信息，包含图片名和大小
        return ResponseMessage.success("图片上传成功",
                String.format("图片名称: %s, 大小: %d bytes",
                        imageFile.getOriginalFilename(),
                        imageFile.getSize()));
    }

    //

}
