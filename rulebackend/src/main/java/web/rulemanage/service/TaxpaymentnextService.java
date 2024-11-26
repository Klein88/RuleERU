package web.rulemanage.service;

import org.springframework.transaction.annotation.Transactional;
import web.rulemanage.domain.Taxdeclaration;
import web.rulemanage.domain.Taxpayment;
import web.rulemanage.domain.Taxpaymentnext;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author xpc
* @description 针对表【TaxPaymentNext】的数据库操作Service
* @createDate 2023-10-26 15:00:27
*/
public interface TaxpaymentnextService extends IService<Taxpaymentnext> {
    @Transactional
    public int addTaxpaymentnext(Taxpaymentnext taxpaymentnext);
    @Transactional
    Taxpaymentnext findTaxpaymentnext(String TaxPaymentNextID);
}
