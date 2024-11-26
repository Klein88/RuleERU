package web.rulemanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Eprdeclaration;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.mapper.CompaniesMapper;
import web.rulemanage.service.EprdeclarationService;
import web.rulemanage.mapper.EprdeclarationMapper;
import org.springframework.stereotype.Service;

/**
* @author xpc
* @description 针对表【EPRDeclaration】的数据库操作Service实现
* @createDate 2023-10-17 09:56:16
*/
@Service
public class EprdeclarationServiceImpl extends ServiceImpl<EprdeclarationMapper, Eprdeclaration>
    implements EprdeclarationService{
    @Resource
    private EprdeclarationMapper eprdeclarationMapper;

    @Override
    public int addEprdeclaration(Eprdeclaration eprdeclaration) {
        if (eprdeclaration == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return eprdeclarationMapper.insert(eprdeclaration);
    }

    @Override
    public Eprdeclaration findEprdeclaration(String DeclarationID) {
        QueryWrapper<Eprdeclaration> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(DeclarationID)) {
            queryWrapper.eq("DeclarationID", DeclarationID);
        }
        return eprdeclarationMapper.selectOne(queryWrapper);
    }

    @Override
    public int updateEprdeclaration(Eprdeclaration eprdeclaration) {
        if (eprdeclaration == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return eprdeclarationMapper.updateById(eprdeclaration);
    }

    @Override
    public int deleteEprdeclaration(int DeclarationID) {
        if (DeclarationID <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return eprdeclarationMapper.deleteById(DeclarationID);
    }
}




