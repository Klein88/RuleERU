package web.rulemanage.service;

import org.springframework.transaction.annotation.Transactional;
import web.rulemanage.domain.Eprregistrationservicedata;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author xpc
* @description 针对表【EPRRegistrationServiceData】的数据库操作Service
* @createDate 2023-10-17 09:56:16
*/
public interface EprregistrationservicedataService extends IService<Eprregistrationservicedata> {
    @Transactional
    public int addEprregistrationservicedata(Eprregistrationservicedata eprregistrationservicedata);

}
