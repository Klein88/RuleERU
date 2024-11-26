package web.rulemanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;
import web.rulemanage.domain.Companyinfo;

/**
* @author xpc
* @description 针对表【CompanyInfo】的数据库操作Service
* @createDate 2023-10-11 14:00:32
*/
public interface CompanyinfoService extends IService<Companyinfo> {
    @Transactional
    Companyinfo findCompanyinfo(String CompanyName);
    @Transactional
    int updateCompanyinfo(Companyinfo companyinfo);

}
