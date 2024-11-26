package web.rulemanage.service;

import org.springframework.transaction.annotation.Transactional;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Packagingsummarydeclaration;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author xpc
* @description 针对表【PackagingSummaryDeclaration】的数据库操作Service
* @createDate 2023-10-17 09:56:16
*/
public interface PackagingsummarydeclarationService extends IService<Packagingsummarydeclaration> {
    @Transactional
    public int addPackagingsummarydeclaration(Packagingsummarydeclaration packagingsummarydeclaration);
    @Transactional
    List<Packagingsummarydeclaration> findPackagingsummarydeclaration(String eprdeclarationid);
    @Transactional
    int updatePackagingsummarydeclaration(Packagingsummarydeclaration packagingsummarydeclaration);
    @Transactional
    public int deletePackagingsummarydeclaration(int SummaryID);
}
