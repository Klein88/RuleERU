package web.rulemanage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import web.rulemanage.domain.SensitiveWords;
import web.rulemanage.service.SensitiveWordsService;
import web.rulemanage.mapper.SensitiveWordsMapper;
import org.springframework.stereotype.Service;

/**
* @author xpc
* @description 针对表【sensitive_words】的数据库操作Service实现
* @createDate 2023-11-14 08:26:30
*/
@Service
public class SensitiveWordsServiceImpl extends ServiceImpl<SensitiveWordsMapper, SensitiveWords>
    implements SensitiveWordsService{

}




