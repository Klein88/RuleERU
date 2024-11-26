package web.rulemanage.service;

import org.springframework.transaction.annotation.Transactional;
import web.rulemanage.domain.Eprservice;
import com.baomidou.mybatisplus.extension.service.IService;
import web.rulemanage.domain.Taxservice;

/**
* @author xpc
* @description 针对表【EPRService】的数据库操作Service
* @createDate 2023-10-29 15:00:11
*/
public interface EprserviceService extends IService<Eprservice> {
    @Transactional
    public int addEprservice(Eprservice eprservice);
    @Transactional
    Eprservice findEprservice(String EprserviceID);
    @Transactional
    int updateEprservice(Eprservice eprservice);
}
