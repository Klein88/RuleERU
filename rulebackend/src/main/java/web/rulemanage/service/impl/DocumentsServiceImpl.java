package web.rulemanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Documents;
import web.rulemanage.mapper.CompaniesMapper;
import web.rulemanage.service.DocumentsService;
import web.rulemanage.mapper.DocumentsMapper;
import org.springframework.stereotype.Service;

/**
* @author xpc
* @description 针对表【Documents】的数据库操作Service实现
* @createDate 2023-10-20 16:41:56
*/
@Service
public class DocumentsServiceImpl extends ServiceImpl<DocumentsMapper, Documents>
    implements DocumentsService{
    @Resource
    private DocumentsMapper documentsMapper;

    @Override
    public Documents findDocuments(String DocumentCategory) {
        QueryWrapper<Documents> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(DocumentCategory)) {
            queryWrapper.eq("DocumentCategory", DocumentCategory);
        }
        return documentsMapper.selectOne(queryWrapper);
    }
}




