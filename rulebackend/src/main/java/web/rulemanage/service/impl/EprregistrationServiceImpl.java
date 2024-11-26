package web.rulemanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Eprregistration;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.mapper.CompaniesMapper;
import web.rulemanage.service.EprregistrationService;
import web.rulemanage.mapper.EprregistrationMapper;
import org.springframework.stereotype.Service;

/**
* @author xpc
* @description 针对表【EPRRegistration】的数据库操作Service实现
* @createDate 2023-10-17 09:56:16
*/
@Service
public class EprregistrationServiceImpl extends ServiceImpl<EprregistrationMapper, Eprregistration>
    implements EprregistrationService{
    @Resource
    private EprregistrationMapper eprregistrationMapper;

    @Override
    public int addEprregistration(Eprregistration eprregistration) {
        if (eprregistration == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return eprregistrationMapper.insert(eprregistration);
    }

    @Override
    public Eprregistration findEprregistration(String RegistrationID) {
        QueryWrapper<Eprregistration> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(RegistrationID)) {
            queryWrapper.eq("RegistrationID", RegistrationID);
        }
        return eprregistrationMapper.selectOne(queryWrapper);
    }

    @Override
    public int updateEprregistration(Eprregistration eprregistration) {
        if (eprregistration == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return eprregistrationMapper.updateById(eprregistration);
    }

    @Override
    public int deleteEprregistration(int RegistrationID) {
        if (RegistrationID <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return eprregistrationMapper.deleteById(RegistrationID);
    }
}




