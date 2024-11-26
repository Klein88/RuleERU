package web.rulemanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.domain.Taxpayment;
import web.rulemanage.domain.Taxpaymentnext;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.mapper.TaxpaymentMapper;
import web.rulemanage.service.TaxpaymentnextService;
import web.rulemanage.mapper.TaxpaymentnextMapper;
import org.springframework.stereotype.Service;

/**
* @author xpc
* @description 针对表【TaxPaymentNext】的数据库操作Service实现
* @createDate 2023-10-26 15:00:27
*/
@Service
public class TaxpaymentnextServiceImpl extends ServiceImpl<TaxpaymentnextMapper, Taxpaymentnext>
    implements TaxpaymentnextService{
    @Resource
    private TaxpaymentnextMapper taxpaymentnextMapper;

    @Override
    public int addTaxpaymentnext(Taxpaymentnext taxpaymentnext) {
        if (taxpaymentnext == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return taxpaymentnextMapper.insert(taxpaymentnext);
    }

    @Override
    public Taxpaymentnext findTaxpaymentnext(String TaxPaymentNextID) {
        QueryWrapper<Taxpaymentnext> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(TaxPaymentNextID)) {
            queryWrapper.eq("TaxPaymentNextID", TaxPaymentNextID);
        }
        return taxpaymentnextMapper.selectOne(queryWrapper);
    }
}




