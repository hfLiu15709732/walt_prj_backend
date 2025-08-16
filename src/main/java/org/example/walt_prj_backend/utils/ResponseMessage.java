package org.example.walt_prj_backend.utils;

import lombok.Data;

@Data
public class ResponseMessage<T> {
    private Integer code;
    private String message;
    private T data;
    private Boolean status;

    public ResponseMessage(Integer code, String message, T data, Boolean status) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.status = status;
    }

    public static <T> ResponseMessage<T> success(T data) {
        return new ResponseMessage<>(200, "操作成功", data, true);
    }

    public static <T> ResponseMessage<T> success(String message, T data) {
        return new ResponseMessage<>(200, message, data, true);
    }

    public static <T> ResponseMessage<T> error(Integer code, String message) {
        return new ResponseMessage<>(code, message, null, false);
    }

    public static <T> ResponseMessage<T> error(String message) {
        return new ResponseMessage<>(500, message, null, false);
    }
}
