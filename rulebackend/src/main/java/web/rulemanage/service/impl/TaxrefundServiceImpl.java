package web.rulemanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.domain.Taxpayment;
import web.rulemanage.domain.Taxrefund;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.mapper.TaxpaymentMapper;
import web.rulemanage.service.TaxrefundService;
import web.rulemanage.mapper.TaxrefundMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author xpc
* @description 针对表【TaxRefund】的数据库操作Service实现
* @createDate 2023-10-26 09:06:44
*/
@Service
public class TaxrefundServiceImpl extends ServiceImpl<TaxrefundMapper, Taxrefund>
    implements TaxrefundService{
    @Resource
    private TaxrefundMapper taxrefundMapper;
    @Override
    public int addTaxrefund(Taxrefund taxrefund) {
        if (taxrefund == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return taxrefundMapper.insert(taxrefund);
    }

    @Override
    public Taxrefund findTaxrefundbyid(String TaxRefundID) {
        QueryWrapper<Taxrefund> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(TaxRefundID)) {
            queryWrapper.eq("TaxRefundID", TaxRefundID);
        }
        return taxrefundMapper.selectOne(queryWrapper);
    }

    @Override
    public int deleteTaxrefund(int TaxRefundID) {
        if (TaxRefundID <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return taxrefundMapper.deleteById(TaxRefundID);
    }

    @Override
    public int updateTaxrefund(Taxrefund taxrefund) {
        if (taxrefund == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return taxrefundMapper.updateById(taxrefund);
    }

    @Override
    public Taxrefund findTaxrefundbyvatnumber(String VATNumber) {
        QueryWrapper<Taxrefund> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(VATNumber)) {
            queryWrapper.eq("VATNumber", VATNumber);
        }
        return taxrefundMapper.selectOne(queryWrapper);
    }


    @Override
    public List<Taxrefund> findTaxrefundByCountry(String Country) {
        QueryWrapper<Taxrefund> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(Country)) {
            queryWrapper.eq("Country", Country);
        }
        return taxrefundMapper.selectList(queryWrapper);
    }
    @Override
    public List<Taxrefund> findTaxrefundbyOperation(String Operation) {
        QueryWrapper<Taxrefund> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(Operation)) {
            queryWrapper.eq("Operation", Operation);
        }
        return taxrefundMapper.selectList(queryWrapper);
    }
}




