package web.rulemanage.service;

import org.springframework.transaction.annotation.Transactional;
import web.rulemanage.domain.Vatpayment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author xpc
* @description 针对表【VatPayment】的数据库操作Service
* @createDate 2023-10-23 14:13:34
*/
public interface VatpaymentService extends IService<Vatpayment> {
    @Transactional
    Vatpayment submitPayment(Vatpayment payment);
    @Transactional
    Vatpayment getPaymentById(String paymentId);
    @Transactional
    boolean updatePayment(String paymentId, Vatpayment updatedPayment);
}
