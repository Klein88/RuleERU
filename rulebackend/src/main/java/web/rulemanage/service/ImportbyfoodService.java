package web.rulemanage.service;

import org.springframework.transaction.annotation.Transactional;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Importbyfood;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author xpc
* @description 针对表【ImportByFood】的数据库操作Service
* @createDate 2023-11-17 15:32:23
*/
public interface ImportbyfoodService extends IService<Importbyfood> {
    @Transactional
    Importbyfood findImportbyfood(String id);
}
