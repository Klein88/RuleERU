package web.rulemanage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import web.rulemanage.domain.Vatpayment;
import web.rulemanage.service.VatpaymentService;
import web.rulemanage.mapper.VatpaymentMapper;
import org.springframework.stereotype.Service;

/**
* @author xpc
* @description 针对表【VatPayment】的数据库操作Service实现
* @createDate 2023-10-23 14:13:34
*/
@Service
public class VatpaymentServiceImpl extends ServiceImpl<VatpaymentMapper, Vatpayment>
    implements VatpaymentService{
    @Resource
    private VatpaymentMapper vatpaymentMapper;

    @Override
    public Vatpayment submitPayment(Vatpayment payment) {
        int result = vatpaymentMapper.insert(payment);
        if (result > 0) {
            return payment; // 返回保存后的对象
        } else {
            throw new RuntimeException("Failed to submit payment.");
        }
    }

    @Override
    public Vatpayment getPaymentById(String paymentId) {
        return vatpaymentMapper.selectById(paymentId);
    }

    @Override
    public boolean updatePayment(String paymentId, Vatpayment updatedPayment) {
        int result = vatpaymentMapper.updateById(updatedPayment);
        return result > 0;
    }
}




