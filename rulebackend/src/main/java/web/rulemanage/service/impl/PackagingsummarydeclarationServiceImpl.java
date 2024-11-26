package web.rulemanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.domain.Packagingsummarydeclaration;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.service.PackagingsummarydeclarationService;
import web.rulemanage.mapper.PackagingsummarydeclarationMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author xpc
* @description 针对表【PackagingSummaryDeclaration】的数据库操作Service实现
* @createDate 2023-10-17 09:56:16
*/
@Service
public class PackagingsummarydeclarationServiceImpl extends ServiceImpl<PackagingsummarydeclarationMapper, Packagingsummarydeclaration>
    implements PackagingsummarydeclarationService{
    @Resource
    private PackagingsummarydeclarationMapper packagingsummarydeclarationMapper;

    @Override
    public int addPackagingsummarydeclaration(Packagingsummarydeclaration packagingsummarydeclaration) {
        if (packagingsummarydeclaration == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return packagingsummarydeclarationMapper.insert(packagingsummarydeclaration);
    }

    @Override
    public List<Packagingsummarydeclaration> findPackagingsummarydeclaration(String eprdeclarationid) {
        QueryWrapper<Packagingsummarydeclaration> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(eprdeclarationid)) {
            queryWrapper.eq("eprdeclarationid", eprdeclarationid);
        }
        return packagingsummarydeclarationMapper.selectList(queryWrapper);
    }

    @Override
    public int updatePackagingsummarydeclaration(Packagingsummarydeclaration packagingsummarydeclaration) {
        if (packagingsummarydeclaration == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return packagingsummarydeclarationMapper.updateById(packagingsummarydeclaration);
    }

    @Override
    public int deletePackagingsummarydeclaration(int SummaryID) {
        if (SummaryID <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return packagingsummarydeclarationMapper.deleteById(SummaryID);
    }
}




