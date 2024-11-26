package web.rulemanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.domain.Eprdeclaration;
import web.rulemanage.domain.Eprdeclaration1;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.mapper.EprdeclarationMapper;
import web.rulemanage.service.Eprdeclaration1Service;
import web.rulemanage.mapper.Eprdeclaration1Mapper;
import org.springframework.stereotype.Service;

/**
* @author xpc
* @description 针对表【EPRDeclaration1】的数据库操作Service实现
* @createDate 2023-10-25 14:36:25
*/
@Service
public class Eprdeclaration1ServiceImpl extends ServiceImpl<Eprdeclaration1Mapper, Eprdeclaration1>
    implements Eprdeclaration1Service{

    @Resource
    private Eprdeclaration1Mapper eprdeclaration1Mapper;
    @Override
    public int addEprdeclaration1(Eprdeclaration1 eprdeclaration1) {
        if (eprdeclaration1 == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return eprdeclaration1Mapper.insert(eprdeclaration1);
    }

    @Override
    public Eprdeclaration1 findEprdeclaration1(String DeclarationID) {
        QueryWrapper<Eprdeclaration1> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(DeclarationID)) {
            queryWrapper.eq("DeclarationID", DeclarationID);
        }
        return eprdeclaration1Mapper.selectOne(queryWrapper);
    }

    @Override
    public int updateEprdeclaration1(Eprdeclaration1 eprdeclaration1) {
        if (eprdeclaration1 == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return eprdeclaration1Mapper.updateById(eprdeclaration1);
    }

    @Override
    public int deleteEprdeclaration1(int DeclarationID) {
        if (DeclarationID <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return eprdeclaration1Mapper.deleteById(DeclarationID);
    }

    @Override
    public Eprdeclaration1 findEprdeclaration1byid(String RegistrationNumber) {
        QueryWrapper<Eprdeclaration1> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(RegistrationNumber)) {
            queryWrapper.eq("RegistrationNumber", RegistrationNumber);
        }
        return eprdeclaration1Mapper.selectOne(queryWrapper);
    }
}




