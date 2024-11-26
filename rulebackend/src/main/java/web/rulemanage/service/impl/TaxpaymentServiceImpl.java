package web.rulemanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Taxpayment;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.mapper.CompaniesMapper;
import web.rulemanage.service.TaxpaymentService;
import web.rulemanage.mapper.TaxpaymentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author xpc
* @description 针对表【TaxPayment】的数据库操作Service实现
* @createDate 2023-10-26 08:45:35
*/
@Service
public class TaxpaymentServiceImpl extends ServiceImpl<TaxpaymentMapper, Taxpayment>
    implements TaxpaymentService{
    @Resource
    private TaxpaymentMapper taxpaymentMapper;
    @Override
    public int addTaxpayment(Taxpayment taxpayment) {
        if (taxpayment == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return taxpaymentMapper.insert(taxpayment);
    }

    @Override
    public Taxpayment findTaxpaymentbyid(String TaxPaymentID) {
        QueryWrapper<Taxpayment> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(TaxPaymentID)) {
            queryWrapper.eq("TaxPaymentID", TaxPaymentID);
        }
        return taxpaymentMapper.selectOne(queryWrapper);
    }

    @Override
    public int deleteTaxpayment(int TaxPaymentID) {
        if (TaxPaymentID <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return taxpaymentMapper.deleteById(TaxPaymentID);
    }

    @Override
    public int updateTaxpayment(Taxpayment taxpayment) {
        if (taxpayment == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return taxpaymentMapper.updateById(taxpayment);
    }

    @Override
    public List<Taxpayment> findTaxpaymentbycompanyname(String CompanyName) {
        QueryWrapper<Taxpayment> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(CompanyName)) {
            queryWrapper.eq("CompanyName", CompanyName);
        }
        return taxpaymentMapper.selectList(queryWrapper);
    }

    @Override
    public List<Taxpayment> findTaxpaymentbyPaymentStatus(String PaymentStatus) {
        QueryWrapper<Taxpayment> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(PaymentStatus)) {
            queryWrapper.eq("PaymentStatus", PaymentStatus);
        }
        return taxpaymentMapper.selectList(queryWrapper);
    }

}




