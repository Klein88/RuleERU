package web.rulemanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import web.rulemanage.domain.Localtaxpolicy;
import web.rulemanage.mapper.LocaltaxpolicyMapper;
import web.rulemanage.service.LocaltaxpolicyService;

import java.util.List;

/**
* @author xpc
* @description 针对表【LocalTaxPolicy】的数据库操作Service实现
* @createDate 2023-10-12 14:28:54
*/
@Service
public class LocaltaxpolicyServiceImpl extends ServiceImpl<LocaltaxpolicyMapper, Localtaxpolicy>
    implements LocaltaxpolicyService{

    @Resource
    private LocaltaxpolicyMapper localtaxpolicyMapper;
    @Override
    public Localtaxpolicy findLocaltaxpolicy(String TaxPolicyDescription) {
        QueryWrapper<Localtaxpolicy> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(TaxPolicyDescription)) {
            queryWrapper.like("TaxPolicyDescription", TaxPolicyDescription);
        }
        List<Localtaxpolicy> results = localtaxpolicyMapper.selectList(queryWrapper);
        if (results.isEmpty()) {
            return null; // 如果没有结果，则返回null
        }
        return results.get(0); // 返回列表中的第一个元素
    }



}




