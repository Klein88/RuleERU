package web.rulemanage.service;

import org.springframework.transaction.annotation.Transactional;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Eudeclarationofconformity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author xpc
* @description 针对表【EUDeclarationOfConformity】的数据库操作Service
* @createDate 2023-10-31 10:19:12
*/
public interface EudeclarationofconformityService extends IService<Eudeclarationofconformity> {
    @Transactional
    public int addEudeclarationofconformity(Eudeclarationofconformity eudeclarationofconformity);
    @Transactional
    Eudeclarationofconformity findEudeclarationofconformity(String DeclarationID);
    @Transactional
    Eudeclarationofconformity findEudeclarationofconformitybyapplicationid(String ApplicationID);
    @Transactional
    int updateEudeclarationofconformity(Eudeclarationofconformity eudeclarationofconformity);
    @Transactional
    public int deleteEudeclarationofconformity(int DeclarationID);
    @Transactional
    public byte[] generateWordDocument(int DeclarationID);
}
