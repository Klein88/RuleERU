package web.rulemanage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import web.rulemanage.domain.SensitiveWords;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author xpc
* @description 针对表【sensitive_words】的数据库操作Mapper
* @createDate 2023-11-14 08:26:30
* @Entity web.rulemanage.domain.SensitiveWords
*/
@Mapper
public interface SensitiveWordsMapper extends BaseMapper<SensitiveWords> {
    @Select("SELECT COUNT(*) FROM sensitive_words WHERE #{content} LIKE CONCAT('%', word, '%')")
    int countMatches(String content);
}




