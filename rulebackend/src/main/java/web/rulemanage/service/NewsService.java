package web.rulemanage.service;

import org.springframework.transaction.annotation.Transactional;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.News;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author xpc
* @description 针对表【News】的数据库操作Service
* @createDate 2023-11-12 16:16:01
*/
public interface NewsService extends IService<News> {
    @Transactional
    News findNews(String NewsID);
}
