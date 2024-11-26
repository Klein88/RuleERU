package web.rulemanage.common;

public class ResultUtils {
    //成功
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(20000, data, "ok"); }
    //失败(1 个参数)
    public static BaseResponse error(ErrorCode errorCode) {
        return new BaseResponse<>(errorCode); }
    //失败(3 个参数)
    public static BaseResponse error(int code, String message, String description) {
        return new BaseResponse(code, null, message, description); }
    //失败(3 个参数)
    public static BaseResponse error(ErrorCode errorCode, String message, String description) {
        return new BaseResponse(errorCode.getCode(), null, message, description); }
    //失败(2 个参数)
    public static BaseResponse error(ErrorCode errorCode, String description) {
        return new BaseResponse(errorCode.getCode(), errorCode.getMessage(), description); }
}

