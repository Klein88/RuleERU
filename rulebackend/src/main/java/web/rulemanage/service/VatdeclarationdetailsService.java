package web.rulemanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;
import web.rulemanage.domain.Vatdeclarationdetails;

/**
* @author xpc
* @description 针对表【VATDeclarationDetails】的数据库操作Service
* @createDate 2023-10-12 14:28:54
*/
public interface VatdeclarationdetailsService extends IService<Vatdeclarationdetails> {
    @Transactional
    public int addVatdeclarationdetails(Vatdeclarationdetails vatdeclarationdetails);
    @Transactional
    Vatdeclarationdetails findVatdeclarationdetails(String DeclarationDetailID);
    @Transactional
    public int deleteVatdeclarationdetails(int DeclarationDetailID);
}
