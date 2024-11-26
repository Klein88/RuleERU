package web.rulemanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import web.rulemanage.domain.Importbyfood;
import web.rulemanage.domain.Importbyyuancailiao;
import web.rulemanage.mapper.ImportbyfoodMapper;
import web.rulemanage.service.ImportbyyuancailiaoService;
import web.rulemanage.mapper.ImportbyyuancailiaoMapper;
import org.springframework.stereotype.Service;

/**
* @author xpc
* @description 针对表【ImportByYuancailiao】的数据库操作Service实现
* @createDate 2023-11-17 15:32:23
*/
@Service
public class ImportbyyuancailiaoServiceImpl extends ServiceImpl<ImportbyyuancailiaoMapper, Importbyyuancailiao>
    implements ImportbyyuancailiaoService{

    @Resource
    private ImportbyyuancailiaoMapper importbyyuancailiaoMapper;
    @Override
    public Importbyyuancailiao findImportbyyuancailiao(String id) {
        QueryWrapper<Importbyyuancailiao> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(id)) {
            queryWrapper.eq("id", id);
        }
        return importbyyuancailiaoMapper.selectOne(queryWrapper);
    }
}




