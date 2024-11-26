package web.rulemanage.mapper;

import org.apache.ibatis.annotations.Param;
import web.rulemanage.domain.Vatpayment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author xpc
* @description 针对表【VatPayment】的数据库操作Mapper
* @createDate 2023-10-23 14:13:34
* @Entity web.rulemanage.domain.Vatpayment
*/
public interface VatpaymentMapper extends BaseMapper<Vatpayment> {

    int insert(Vatpayment payment);
    Vatpayment selectById(@Param("id") String paymentId);
    int updateById(Vatpayment updatedPayment);
}




