package web.rulemanage.service;

import org.springframework.transaction.annotation.Transactional;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Documents;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author xpc
* @description 针对表【Documents】的数据库操作Service
* @createDate 2023-10-20 16:41:56
*/
public interface DocumentsService extends IService<Documents> {
    @Transactional
    Documents findDocuments(String DocumentCategory);
}
