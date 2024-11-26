package web.rulemanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Taxservice;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.mapper.CompaniesMapper;
import web.rulemanage.service.TaxserviceService;
import web.rulemanage.mapper.TaxserviceMapper;
import org.springframework.stereotype.Service;

/**
* @author xpc
* @description 针对表【TaxService】的数据库操作Service实现
* @createDate 2023-10-23 22:34:49
*/
@Service
public class TaxserviceServiceImpl extends ServiceImpl<TaxserviceMapper, Taxservice>
    implements TaxserviceService{
    @Resource
    private TaxserviceMapper taxserviceMapper;

    @Override
    public int addTaxservice(Taxservice taxservice) {
        if (taxservice == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return taxserviceMapper.insert(taxservice);
    }

    @Override
    public Taxservice findTaxservice(String TaxServiceID) {
        QueryWrapper<Taxservice> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(TaxServiceID)) {
            queryWrapper.eq("TaxServiceID", TaxServiceID);
        }
        return taxserviceMapper.selectOne(queryWrapper);
    }

    @Override
    public Taxservice findTaxservicebyvatnumber(String VATNumber) {
        QueryWrapper<Taxservice> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(VATNumber)) {
            queryWrapper.eq("VATNumber", VATNumber);
        }
        return taxserviceMapper.selectOne(queryWrapper);
    }

    @Override
    public int updateTaxservice(Taxservice taxservice) {
        if (taxservice == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return taxserviceMapper.updateById(taxservice);
    }
}




