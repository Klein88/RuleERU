package web.rulemanage.service;

import org.springframework.transaction.annotation.Transactional;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Complianceapplication;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author xpc
* @description 针对表【ComplianceApplication】的数据库操作Service
* @createDate 2023-10-31 10:19:12
*/
public interface ComplianceapplicationService extends IService<Complianceapplication> {
    @Transactional
    public int addComplianceapplication(Complianceapplication complianceapplication);
    @Transactional
    Complianceapplication findComplianceapplication(String ApplicationID);
    @Transactional
    public int deleteComplianceapplication(int ApplicationID);
}
