package web.rulemanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.rulemanage.common.BaseResponse;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.common.ResultUtils;
import web.rulemanage.config.JwtUtil;
import web.rulemanage.domain.User;
import web.rulemanage.service.UserService;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "https://127.0.0.1:5173", allowCredentials = "true")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;

//    @PostMapping("/login")
//    public BaseResponse<User> handleLogin(@RequestBody User user) {
//        User validatedUser = userService.validateUser(user.getUsername(), user.getPassword());
//        if (validatedUser != null) {
//            return ResultUtils.success(validatedUser);  // 登录成功返回用户信息
//        } else {
//            return ResultUtils.error(ErrorCode.PARAMS_ERROR);
//        }
//    }

    @PostMapping("/login")
    public BaseResponse<String> handleLogin(@RequestBody User user) {
        User validatedUser = userService.validateUser(user.getUsername(), user.getPassword());
        if (validatedUser != null) {
            String token = jwtUtil.generateToken(validatedUser.getUsername());  // 生成JWT
            return ResultUtils.success(token);  // 返回JWT令牌
        } else {
            return ResultUtils.error(ErrorCode.PARAMS_ERROR, "Invalid credentials");
        }
    }

    @PostMapping("/register")
    public BaseResponse<String> handleRegister(@RequestBody User user) {
        if (userService.registerUser(user)) {
            return ResultUtils.success("Registration successful");
        } else {
            return ResultUtils.error(ErrorCode.PARAMS_ERROR);
        }
    }

}

