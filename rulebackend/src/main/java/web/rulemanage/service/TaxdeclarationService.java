package web.rulemanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;
import web.rulemanage.domain.Taxdeclaration;

/**
* @author xpc
* @description 针对表【TaxDeclaration】的数据库操作Service
* @createDate 2023-10-12 09:21:56
*/
public interface TaxdeclarationService extends IService<Taxdeclaration> {
    @Transactional
    public int addTaxdeclaration(Taxdeclaration taxdeclaration);
    @Transactional
    Taxdeclaration findTaxdeclaration(String DeclarationID);
    @Transactional
    public int deleteTaxdeclaration(int DeclarationID);
    @Transactional
    Taxdeclaration findTaxdeclarationbysearchbyvatnumber(String searchbyvatnumber);

    @Transactional
    Taxdeclaration findTaxdeclarationbyvatnumber(String VATNumber);

}
