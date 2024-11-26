package web.rulemanage.service;

import org.springframework.transaction.annotation.Transactional;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Taxservice;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author xpc
* @description 针对表【TaxService】的数据库操作Service
* @createDate 2023-10-23 22:34:49
*/
public interface TaxserviceService extends IService<Taxservice> {
    @Transactional
    public int addTaxservice(Taxservice taxservice);
    @Transactional
    Taxservice findTaxservice(String TaxServiceID);
    @Transactional
    Taxservice findTaxservicebyvatnumber(String VATNumber);
    @Transactional
    int updateTaxservice(Taxservice taxservice);
}
