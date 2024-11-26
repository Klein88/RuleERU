package web.rulemanage.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResponse<T> implements Serializable {
    private int code;
    private T data;
    private String message;
    private String description;
    // BaseResponse 构造函数(4 个参数)
    public BaseResponse(int code, T data, String message, String description) {
        this.code = code;
        this.data = data;
        this.message = message; this.description = description;
    }
    // BaseResponse 构造函数(3 个参数)
    public BaseResponse(int code, T data, String message) {
        this.code = code; this.data = data; this.message = message;
    }
    // BaseResponse 构造函数(2 个参数)
    public BaseResponse(int code, T data) {
        this.code = code;
        this.data = data;
    }
    // BaseResponse 构造函数(1 个参数)
    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(), null, errorCode.getMessage(), errorCode.getDescription());
    }
}

