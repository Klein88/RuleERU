package web.rulemanage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.rulemanage.mapper.SensitiveWordsMapper;
import web.rulemanage.service.ContentCheckService;

import javax.annotation.Resource;

@Service
@Transactional(readOnly = true)
public class ContentCheckServiceImpl implements ContentCheckService {

    @Resource
    private SensitiveWordsMapper sensitiveWordsMapper;

    @Autowired
    public ContentCheckServiceImpl(SensitiveWordsMapper sensitiveWordsMapper) {
        this.sensitiveWordsMapper = sensitiveWordsMapper;
    }

    @Override
    public boolean checkContent(String content) {
        // 查询数据库中与输入内容匹配的敏感词数量
        int matchCount = sensitiveWordsMapper.countMatches(content);
        // 如果有匹配的，返回false表示内容不合规
        return matchCount == 0;
    }
}