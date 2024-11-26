package web.rulemanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;
import web.rulemanage.domain.Companies;

/**
* @author xpc
* @description 针对表【Companies】的数据库操作Service
* @createDate 2023-10-11 14:00:32
*/
public interface CompaniesService extends IService<Companies> {
        @Transactional
        public int addCompanies(Companies companies);
        @Transactional
        Companies findCompanies(String CompanyID);
        @Transactional
        int updateCompanies(Companies companies);
        @Transactional
        public int deleteCompanies(int CompanyID);
}
