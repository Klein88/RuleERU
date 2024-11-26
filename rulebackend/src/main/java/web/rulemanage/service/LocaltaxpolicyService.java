package web.rulemanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;
import web.rulemanage.domain.Localtaxpolicy;

/**
* @author xpc
* @description 针对表【LocalTaxPolicy】的数据库操作Service
* @createDate 2023-10-12 14:28:54
*/
public interface LocaltaxpolicyService extends IService<Localtaxpolicy> {
    @Transactional
    Localtaxpolicy findLocaltaxpolicy(String TaxPolicyDescription);
}
