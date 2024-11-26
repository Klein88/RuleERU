package web.rulemanage.service;

import org.springframework.transaction.annotation.Transactional;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Eprregistration;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author xpc
* @description 针对表【EPRRegistration】的数据库操作Service
* @createDate 2023-10-17 09:56:16
*/
public interface EprregistrationService extends IService<Eprregistration> {
    @Transactional
    public int addEprregistration(Eprregistration eprregistration);
    @Transactional
    Eprregistration findEprregistration(String RegistrationID);
    @Transactional
    int updateEprregistration(Eprregistration eprregistration);
    @Transactional
    public int deleteEprregistration(int RegistrationID);
}
