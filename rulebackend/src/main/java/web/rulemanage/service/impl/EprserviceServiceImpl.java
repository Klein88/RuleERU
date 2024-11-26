package web.rulemanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.domain.Eprservice;
import web.rulemanage.domain.Taxservice;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.mapper.TaxserviceMapper;
import web.rulemanage.service.EprserviceService;
import web.rulemanage.mapper.EprserviceMapper;
import org.springframework.stereotype.Service;

/**
* @author xpc
* @description 针对表【EPRService】的数据库操作Service实现
* @createDate 2023-10-29 15:00:11
*/
@Service
public class EprserviceServiceImpl extends ServiceImpl<EprserviceMapper, Eprservice>
    implements EprserviceService{

    @Resource
    private EprserviceMapper eprserviceMapper;

    @Override
    public int addEprservice(Eprservice eprservice) {
        if (eprservice == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return eprserviceMapper.insert(eprservice);
    }

    @Override
    public Eprservice findEprservice(String EprserviceID) {
        QueryWrapper<Eprservice> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(EprserviceID)) {
            queryWrapper.eq("EprserviceID", EprserviceID);
        }
        return eprserviceMapper.selectOne(queryWrapper);
    }

    @Override
    public int updateEprservice(Eprservice eprservice) {
        if (eprservice == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return eprserviceMapper.updateById(eprservice);
    }
}




