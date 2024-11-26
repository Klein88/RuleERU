package web.rulemanage.service;

import org.springframework.transaction.annotation.Transactional;
import web.rulemanage.domain.Importbyfood;
import web.rulemanage.domain.Importbyjixie;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author xpc
* @description 针对表【ImportByJixie】的数据库操作Service
* @createDate 2023-11-17 15:32:23
*/
public interface ImportbyjixieService extends IService<Importbyjixie> {
    @Transactional
    Importbyjixie findImportbyjixie(String id);
}
