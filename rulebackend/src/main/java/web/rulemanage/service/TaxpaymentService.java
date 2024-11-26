package web.rulemanage.service;

import org.springframework.transaction.annotation.Transactional;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Taxdeclaration;
import web.rulemanage.domain.Taxpayment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author xpc
* @description 针对表【TaxPayment】的数据库操作Service
* @createDate 2023-10-26 08:45:35
*/
public interface TaxpaymentService extends IService<Taxpayment> {
    @Transactional
    public int addTaxpayment(Taxpayment taxpayment);
    @Transactional
    Taxpayment findTaxpaymentbyid(String TaxPaymentID);
    @Transactional
    public int deleteTaxpayment(int TaxPaymentID);
    @Transactional
    int updateTaxpayment(Taxpayment taxpayment);
    @Transactional
    List<Taxpayment> findTaxpaymentbycompanyname(String CompanyName);
    @Transactional
    List<Taxpayment> findTaxpaymentbyPaymentStatus(String PaymentStatus);
}
