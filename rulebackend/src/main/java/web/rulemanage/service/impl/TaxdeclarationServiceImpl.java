package web.rulemanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.config.AESUtil;
import web.rulemanage.domain.Taxdeclaration;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.mapper.TaxdeclarationMapper;
import web.rulemanage.service.TaxdeclarationService;

/**
 * @author xpc
 * @description 针对表【TaxDeclaration】的数据库操作Service实现
 * @createDate 2023-10-12 09:21:56
 */
@Service
public class TaxdeclarationServiceImpl extends ServiceImpl<TaxdeclarationMapper, Taxdeclaration>
        implements TaxdeclarationService {

    @Resource
    private TaxdeclarationMapper taxdeclarationMapper;
    @Value("${taxdeclaration.encryption.key}")
    private String encryptionKey;

    //    @Override
//    public int addTaxdeclaration(Taxdeclaration taxdeclaration) {
//        if (taxdeclaration == null) {
//            throw new BusinessException(ErrorCode.PARAMS_ERROR);
//        }
//        return taxdeclarationMapper.insert(taxdeclaration);
//    }
    @Override
    public int addTaxdeclaration(Taxdeclaration taxdeclaration) {
        if (taxdeclaration == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        encryptTaxdeclaration(taxdeclaration);
        return taxdeclarationMapper.insert(taxdeclaration);
    }

    @Override
    public Taxdeclaration findTaxdeclaration(String DeclarationID) {
        QueryWrapper<Taxdeclaration> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(DeclarationID)) {
            queryWrapper.eq("DeclarationID", DeclarationID);
        }
        return taxdeclarationMapper.selectOne(queryWrapper);
    }

    @Override
    public int deleteTaxdeclaration(int DeclarationID) {
        if (DeclarationID <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return taxdeclarationMapper.deleteById(DeclarationID);
    }

    @Override
    public Taxdeclaration findTaxdeclarationbysearchbyvatnumber(String searchbyvatnumber) {
        QueryWrapper<Taxdeclaration> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(searchbyvatnumber)) {
            queryWrapper.eq("searchbyvatnumber", searchbyvatnumber);
        }
        return taxdeclarationMapper.selectOne(queryWrapper);
    }

    @Override
    public Taxdeclaration findTaxdeclarationbyvatnumber(String VATNumber) {
        QueryWrapper<Taxdeclaration> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(VATNumber)) {
            queryWrapper.eq("VATNumber", VATNumber);
        }
        return taxdeclarationMapper.selectOne(queryWrapper);
    }

    private void encryptTaxdeclaration(Taxdeclaration taxdeclaration) {
        try {
            // 举例对 vatnumber 字段进行加密
            String encryptedVatNumber = AESUtil.encrypt(taxdeclaration.getVatnumber(), encryptionKey);
            taxdeclaration.setVatnumber(encryptedVatNumber);
            // 对 gatewayid 进行加密
            String encryptedGatewayId = AESUtil.encrypt(taxdeclaration.getGatewayid(), encryptionKey);
            taxdeclaration.setGatewayid(encryptedGatewayId);

            // 对 gatewaypassword 进行加密
            String encryptedGatewayPassword = AESUtil.encrypt(taxdeclaration.getGatewaypassword(), encryptionKey);
            taxdeclaration.setGatewaypassword(encryptedGatewayPassword);

            // 对 mtdusername 进行加密
            String encryptedMtdUsername = AESUtil.encrypt(taxdeclaration.getMtdusername(), encryptionKey);
            taxdeclaration.setMtdusername(encryptedMtdUsername);

            // 对 mtdpassword 进行加密
            String encryptedMtdPassword = AESUtil.encrypt(taxdeclaration.getMtdpassword(), encryptionKey);
            taxdeclaration.setMtdpassword(encryptedMtdPassword);
            // 对其他需要加密的字段执行类似操作
        } catch (Exception e) {
            e.printStackTrace();
            // 处理加密异常
        }
    }

    private void decryptTaxdeclaration(Taxdeclaration taxdeclaration) {
        try {
            // 举例对 vatnumber 字段进行解密
            String decryptedVatNumber = AESUtil.decrypt(taxdeclaration.getVatnumber(), encryptionKey);
            taxdeclaration.setVatnumber(decryptedVatNumber);
            // 对其他需要解密的字段执行类似操作
        } catch (Exception e) {
            e.printStackTrace();
            // 处理解密异常
        }
    }
}




