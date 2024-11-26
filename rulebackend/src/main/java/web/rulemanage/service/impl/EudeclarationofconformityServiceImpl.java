package web.rulemanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Eudeclarationofconformity;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.service.EudeclarationofconformityService;
import web.rulemanage.mapper.EudeclarationofconformityMapper;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
* @author xpc
* @description 针对表【EUDeclarationOfConformity】的数据库操作Service实现
* @createDate 2023-10-31 10:19:12
*/
@Service
public class EudeclarationofconformityServiceImpl extends ServiceImpl<EudeclarationofconformityMapper, Eudeclarationofconformity>
    implements EudeclarationofconformityService{

    @Resource
    private EudeclarationofconformityMapper eudeclarationofconformityMapper;
    @Override
    public int addEudeclarationofconformity(Eudeclarationofconformity eudeclarationofconformity) {
        if (eudeclarationofconformity == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return eudeclarationofconformityMapper.insert(eudeclarationofconformity);
    }

    @Override
    public Eudeclarationofconformity findEudeclarationofconformity(String DeclarationID) {
        QueryWrapper<Eudeclarationofconformity> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(DeclarationID)) {
            queryWrapper.eq("DeclarationID", DeclarationID);
        }
        return eudeclarationofconformityMapper.selectOne(queryWrapper);
    }

    @Override
    public Eudeclarationofconformity findEudeclarationofconformitybyapplicationid(String ApplicationID) {
        QueryWrapper<Eudeclarationofconformity> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(ApplicationID)) {
            queryWrapper.eq("ApplicationID", ApplicationID);
        }
        return eudeclarationofconformityMapper.selectOne(queryWrapper);
    }

    @Override
    public int updateEudeclarationofconformity(Eudeclarationofconformity eudeclarationofconformity) {
        if (eudeclarationofconformity == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return eudeclarationofconformityMapper.updateById(eudeclarationofconformity);
    }

    @Override
    public int deleteEudeclarationofconformity(int DeclarationID) {
        if (DeclarationID <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return eudeclarationofconformityMapper.deleteById(DeclarationID);
    }
    @Override
    public byte[] generateWordDocument(int DeclarationID) {
        Eudeclarationofconformity declaration = eudeclarationofconformityMapper.selectById(DeclarationID);
        if (declaration == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        // 使用 Apache POI 创建 Word 文档
        XWPFDocument document = new XWPFDocument();

        // 添加内容到文档
        addParagraph(document, "Manufacturer Name: " + declaration.getManufacturername());
        addParagraph(document, "Business Address: " + declaration.getBusinessaddress());
        addParagraph(document, "Authorized Representative: " + declaration.getAuthorizedrepresentative());
        addParagraph(document, "Product Serial Number: " + declaration.getProductserialnumber());
        addParagraph(document, "Model Or Type Identification: " + declaration.getModelortypeidentification());
        addParagraph(document, "Responsibility Statement: " + declaration.getResponsibilitystatement());
        addParagraph(document, "Product Identification: " + declaration.getProductidentification());
        addParagraph(document, "Notified Body Details: " + declaration.getNotifiedbodydetails());
        addParagraph(document, "Legislation And Standards: " + declaration.getLegislationandstandards());
        addParagraph(document, "Signatory Name: " + declaration.getSignatoryname());
        addParagraph(document, "Declaration Date: " + declaration.getDeclarationdate());
        addParagraph(document, "Supplementary Information: " + declaration.getSupplementaryinformation());
        addParagraph(document, "Importer Responsibility: " + declaration.getImporterresponsibility());
        addParagraph(document, "Translation Requirement: " + declaration.getTranslationrequirement());

        // 将文档转换为字节数组
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            document.write(byteArrayOutputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    private void addParagraph(XWPFDocument document, String text) {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(text);
        // 可以在这里设置字体、大小等格式
    }
}




