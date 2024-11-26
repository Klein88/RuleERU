package web.rulemanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.domain.Companies;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.mapper.CompaniesMapper;
import web.rulemanage.service.CompaniesService;

/**
 * @author xpc
 * @description 针对表【Companies】的数据库操作Service实现
 * @createDate 2023-10-11 14:00:32
 */
@Service
public class CompaniesServiceImpl extends ServiceImpl<CompaniesMapper, Companies>
        implements CompaniesService {
    @Resource
    private CompaniesMapper companiesMapper;

    @Override
    public int addCompanies(Companies companies) {
        if (companies == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return companiesMapper.insert(companies);
    }

    @Override
    public Companies findCompanies(String CompanyID) {
        QueryWrapper<Companies> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(CompanyID)) {
            queryWrapper.eq("CompanyID", CompanyID);
        }
        return companiesMapper.selectOne(queryWrapper);
    }

    @Override
    public int updateCompanies(Companies companies) {
        if (companies == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return companiesMapper.updateById(companies);
    }

    @Override
    public int deleteCompanies(int CompanyID) {
        if (CompanyID <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return companiesMapper.deleteById(CompanyID);
    }
}




