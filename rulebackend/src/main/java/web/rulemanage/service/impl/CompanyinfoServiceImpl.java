package web.rulemanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.domain.Companyinfo;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.mapper.CompanyinfoMapper;
import web.rulemanage.service.CompanyinfoService;

/**
* @author xpc
* @description 针对表【CompanyInfo】的数据库操作Service实现
* @createDate 2023-10-11 14:00:32
*/
@Service
public class CompanyinfoServiceImpl extends ServiceImpl<CompanyinfoMapper, Companyinfo>
    implements CompanyinfoService{
    @Resource
    private CompanyinfoMapper companyinfoMapper;

    @Override
    public Companyinfo findCompanyinfo(String CompanyName) {
        QueryWrapper<Companyinfo> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(CompanyName)) {
            queryWrapper.eq("CompanyName", CompanyName);
        }
        return companyinfoMapper.selectOne(queryWrapper);
    }

    @Override
    public int updateCompanyinfo(Companyinfo companyinfo) {
        if (companyinfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return companyinfoMapper.updateById(companyinfo);
    }
}




