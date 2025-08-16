package org.example.walt_prj_backend.exception;

import org.example.walt_prj_backend.utils.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class GlobeExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobeExceptionHandler.class);

    /**
     * 捕获所有未处理的异常，并统一返回错误信息
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseMessage<Void> handleAllExceptions(Exception ex) {
        // 使用 log.error() 记录异常，便于日志管理和分析
        log.error("服务器内部错误: ", ex);
        // 统一返回500错误码和异常信息
        return ResponseMessage.error(500, "服务器内部错误: " + ex.getMessage());
    }
}
