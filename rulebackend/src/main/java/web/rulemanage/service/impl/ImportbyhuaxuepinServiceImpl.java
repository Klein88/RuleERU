package web.rulemanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import web.rulemanage.domain.Importbyfood;
import web.rulemanage.domain.Importbyhuaxuepin;
import web.rulemanage.mapper.ImportbyfoodMapper;
import web.rulemanage.service.ImportbyhuaxuepinService;
import web.rulemanage.mapper.ImportbyhuaxuepinMapper;
import org.springframework.stereotype.Service;

/**
* @author xpc
* @description 针对表【ImportByHuaxuepin】的数据库操作Service实现
* @createDate 2023-11-17 15:32:23
*/
@Service
public class ImportbyhuaxuepinServiceImpl extends ServiceImpl<ImportbyhuaxuepinMapper, Importbyhuaxuepin>
    implements ImportbyhuaxuepinService{
    @Resource
    private ImportbyhuaxuepinMapper importbyhuaxuepinMapper;
    @Override
    public Importbyhuaxuepin findImportbyhuaxuepin(String id) {
        QueryWrapper<Importbyhuaxuepin> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(id)) {
            queryWrapper.eq("id", id);
        }
        return importbyhuaxuepinMapper.selectOne(queryWrapper);
    }
}




