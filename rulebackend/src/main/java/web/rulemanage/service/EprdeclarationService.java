package web.rulemanage.service;

import org.springframework.transaction.annotation.Transactional;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Eprdeclaration;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author xpc
* @description 针对表【EPRDeclaration】的数据库操作Service
* @createDate 2023-10-17 09:56:16
*/
public interface EprdeclarationService extends IService<Eprdeclaration> {
    //可删
    @Transactional
    public int addEprdeclaration(Eprdeclaration eprdeclaration);
    @Transactional
    Eprdeclaration findEprdeclaration(String DeclarationID);
    @Transactional
    int updateEprdeclaration(Eprdeclaration eprdeclaration);
    @Transactional
    public int deleteEprdeclaration(int DeclarationID);
}
