package web.rulemanage.service;

import org.springframework.transaction.annotation.Transactional;
import web.rulemanage.domain.Eprdeclaration;
import web.rulemanage.domain.Eprdeclaration1;
import com.baomidou.mybatisplus.extension.service.IService;
import web.rulemanage.domain.Eprservice;

/**
* @author xpc
* @description 针对表【EPRDeclaration1】的数据库操作Service
* @createDate 2023-10-25 14:36:25
*/
public interface Eprdeclaration1Service extends IService<Eprdeclaration1> {
    @Transactional
    public int addEprdeclaration1(Eprdeclaration1 eprdeclaration1);
    @Transactional
    Eprdeclaration1 findEprdeclaration1(String DeclarationID);
    @Transactional
    int updateEprdeclaration1(Eprdeclaration1 eprdeclaration1);
    @Transactional
    public int deleteEprdeclaration1(int DeclarationID);
    @Transactional
    Eprdeclaration1 findEprdeclaration1byid(String RegistrationNumber);
}
