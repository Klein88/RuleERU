package web.rulemanage.service;

import org.springframework.transaction.annotation.Transactional;
import web.rulemanage.domain.Taxpayment;
import web.rulemanage.domain.Taxrefund;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author xpc
* @description 针对表【TaxRefund】的数据库操作Service
* @createDate 2023-10-26 09:06:44
*/
public interface TaxrefundService extends IService<Taxrefund> {
    @Transactional
    public int addTaxrefund(Taxrefund taxrefund);
    @Transactional
    Taxrefund findTaxrefundbyid(String TaxRefundID);
    @Transactional
    public int deleteTaxrefund(int TaxRefundID);
    @Transactional
    int updateTaxrefund(Taxrefund taxrefund);
    @Transactional
    Taxrefund findTaxrefundbyvatnumber(String VATNumber);
    @Transactional
    List<Taxrefund> findTaxrefundByCountry(String Country);
    @Transactional
    List<Taxrefund> findTaxrefundbyOperation(String Operation);
}
