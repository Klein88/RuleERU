package web.rulemanage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Eprregistrationservicedata;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.mapper.CompaniesMapper;
import web.rulemanage.service.EprregistrationservicedataService;
import web.rulemanage.mapper.EprregistrationservicedataMapper;
import org.springframework.stereotype.Service;

/**
* @author xpc
* @description 针对表【EPRRegistrationServiceData】的数据库操作Service实现
* @createDate 2023-10-17 09:56:16
*/
@Service
public class EprregistrationservicedataServiceImpl extends ServiceImpl<EprregistrationservicedataMapper, Eprregistrationservicedata>
    implements EprregistrationservicedataService{
    @Resource
    private EprregistrationservicedataMapper eprregistrationservicedataMapper;
    @Override
    public int addEprregistrationservicedata(Eprregistrationservicedata eprregistrationservicedata) {
        if (eprregistrationservicedata == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return eprregistrationservicedataMapper.insert(eprregistrationservicedata);
    }
}




