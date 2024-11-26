package web.rulemanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.rulemanage.common.BaseResponse;
import web.rulemanage.common.ResultUtils;
import web.rulemanage.domain.Companyinfo;
import web.rulemanage.domain.Documents;
import web.rulemanage.service.DocumentsService;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://127.0.0.1:5173",allowCredentials = "true")
public class DocumentsController {
    @Resource
    private DocumentsService documentsService;
    @GetMapping("/Documents/find")
    public BaseResponse<Documents> findDocumentsinfo(String documentcategory){
        Documents documents = documentsService.findDocuments(documentcategory);
        return ResultUtils.success(documents);
    }
    @GetMapping("/Documents/pageList")
    public BaseResponse<Page<Documents>> findAllDocumentsinfo(long pageSize, long pageNum){
        QueryWrapper<Documents> queryWrapper = new QueryWrapper<>();
        Page<Documents> documentsPage = documentsService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return ResultUtils.success(documentsPage);
    }
}
