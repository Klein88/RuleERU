package web.rulemanage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;

import org.springframework.stereotype.Service;
import web.rulemanage.domain.User;
import web.rulemanage.mapper.UserMapper;
import web.rulemanage.service.UserService;

import java.util.Collections;

/**
* @author xpc
* @description 针对表【User】的数据库操作Service实现
* @createDate 2023-10-11 14:00:32
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    @Resource
    private UserMapper userMapper;

    @Override
    public User validateUser(String username, String password) {
        return userMapper.findUserByUsernameAndPassword(username, password);
    }
    @Override
    public boolean registerUser(User user) {
        int result = userMapper.insertUser(user);
        return result > 0;
    }


}