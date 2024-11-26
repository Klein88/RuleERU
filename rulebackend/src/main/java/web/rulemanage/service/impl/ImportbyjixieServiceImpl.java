package web.rulemanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import web.rulemanage.domain.Importbyfood;
import web.rulemanage.domain.Importbyjixie;
import web.rulemanage.mapper.ImportbyfoodMapper;
import web.rulemanage.service.ImportbyjixieService;
import web.rulemanage.mapper.ImportbyjixieMapper;
import org.springframework.stereotype.Service;

/**
* @author xpc
* @description 针对表【ImportByJixie】的数据库操作Service实现
* @createDate 2023-11-17 15:32:23
*/
@Service
public class ImportbyjixieServiceImpl extends ServiceImpl<ImportbyjixieMapper, Importbyjixie>
    implements ImportbyjixieService{
    @Resource
    private ImportbyjixieMapper importbyjixieMapper;

    @Override
    public Importbyjixie findImportbyjixie(String id) {
        QueryWrapper<Importbyjixie> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(id)) {
            queryWrapper.eq("id", id);
        }
        return importbyjixieMapper.selectOne(queryWrapper);
    }
}




