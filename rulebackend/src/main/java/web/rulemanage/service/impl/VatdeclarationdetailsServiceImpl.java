package web.rulemanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.domain.Vatdeclarationdetails;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.mapper.VatdeclarationdetailsMapper;
import web.rulemanage.service.VatdeclarationdetailsService;

/**
* @author xpc
* @description 针对表【VATDeclarationDetails】的数据库操作Service实现
* @createDate 2023-10-12 14:28:54
*/
@Service
public class VatdeclarationdetailsServiceImpl extends ServiceImpl<VatdeclarationdetailsMapper, Vatdeclarationdetails>
    implements VatdeclarationdetailsService{

    @Resource
    private VatdeclarationdetailsMapper vatdeclarationdetailsMapper;

    @Override
    public int addVatdeclarationdetails(Vatdeclarationdetails vatdeclarationdetails) {
        if (vatdeclarationdetails == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return vatdeclarationdetailsMapper.insert(vatdeclarationdetails);
    }

    @Override
    public Vatdeclarationdetails findVatdeclarationdetails(String DeclarationDetailID) {
        QueryWrapper<Vatdeclarationdetails> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(DeclarationDetailID)) {
            queryWrapper.eq("DeclarationDetailID", DeclarationDetailID);
        }
        return vatdeclarationdetailsMapper.selectOne(queryWrapper);
    }

    @Override
    public int deleteVatdeclarationdetails(int DeclarationDetailID) {
        if (DeclarationDetailID <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return vatdeclarationdetailsMapper.deleteById(DeclarationDetailID);
    }
}




