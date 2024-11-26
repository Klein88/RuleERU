package web.rulemanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Complianceapplication;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.service.ComplianceapplicationService;
import web.rulemanage.mapper.ComplianceapplicationMapper;
import org.springframework.stereotype.Service;

/**
* @author xpc
* @description 针对表【ComplianceApplication】的数据库操作Service实现
* @createDate 2023-10-31 10:19:12
*/
@Service
public class ComplianceapplicationServiceImpl extends ServiceImpl<ComplianceapplicationMapper, Complianceapplication>
    implements ComplianceapplicationService{
    @Resource
    private ComplianceapplicationMapper complianceapplicationMapper;
    @Override
    public int addComplianceapplication(Complianceapplication complianceapplication) {
        if (complianceapplication == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return complianceapplicationMapper.insert(complianceapplication);
    }

    @Override
    public Complianceapplication findComplianceapplication(String ApplicationID) {
        QueryWrapper<Complianceapplication> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(ApplicationID)) {
            queryWrapper.eq("ApplicationID", ApplicationID);
        }
        return complianceapplicationMapper.selectOne(queryWrapper);
    }



    @Override
    public int deleteComplianceapplication(int ApplicationID) {
        if (ApplicationID <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return complianceapplicationMapper.deleteById(ApplicationID);
    }
}




