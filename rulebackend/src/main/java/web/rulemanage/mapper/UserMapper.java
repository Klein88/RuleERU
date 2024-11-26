package web.rulemanage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import web.rulemanage.domain.User;

/**
* @author xpc
* @description 针对表【User】的数据库操作Mapper
* @createDate 2023-10-11 14:00:32
* @Entity web.rulemanage.domain.User
*/
//public interface UserMapper extends BaseMapper<User> {
//    @Select("SELECT * FROM User WHERE username=#{username} AND password=#{password}")
//    User findUserByUsernameAndPassword(String username, String password);
//    int insertUser(User user);
//}
//
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT * FROM User WHERE username = #{username} AND password = #{password}")
    User findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    @Insert("INSERT INTO User (username, password) VALUES (#{username}, #{password})")
    int insertUser(User user);
    User findUserByUsername(String username);
}



