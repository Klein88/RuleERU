package web.rulemanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;
import web.rulemanage.domain.User;

/**
* @author xpc
* @description 针对表【User】的数据库操作Service
* @createDate 2023-10-11 14:00:32
*/
public interface UserService extends IService<User> {
    @Transactional
    User validateUser(String username, String password);
    @Transactional
    boolean registerUser(User user);
}
