package web.rulemanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Importbyfood;
import web.rulemanage.mapper.CompaniesMapper;
import web.rulemanage.service.ImportbyfoodService;
import web.rulemanage.mapper.ImportbyfoodMapper;
import org.springframework.stereotype.Service;

/**
* @author xpc
* @description 针对表【ImportByFood】的数据库操作Service实现
* @createDate 2023-11-17 15:32:23
*/
@Service
public class ImportbyfoodServiceImpl extends ServiceImpl<ImportbyfoodMapper, Importbyfood>
    implements ImportbyfoodService{
    @Resource
    private ImportbyfoodMapper importbyfoodMapper;

    @Override
    public Importbyfood findImportbyfood(String id) {
        QueryWrapper<Importbyfood> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(id)) {
            queryWrapper.eq("id", id);
        }
        return importbyfoodMapper.selectOne(queryWrapper);
    }
}




