package web.rulemanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.rulemanage.common.BaseResponse;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.common.ResultUtils;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Eudeclarationofconformity;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.service.EudeclarationofconformityService;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://127.0.0.1:5173",allowCredentials = "true")
public class EudeclarationofconformityController {
    @Resource
    private EudeclarationofconformityService eudeclarationofconformityService;

    @GetMapping("/Eudeclarationofconformity/find")
    public BaseResponse<Eudeclarationofconformity> findEudeclarationofconformity(String declarationid){
        Eudeclarationofconformity eudeclarationofconformity = eudeclarationofconformityService.findEudeclarationofconformity(declarationid);
        return ResultUtils.success(eudeclarationofconformity);
    }
    @GetMapping("/Eudeclarationofconformity/findbyapplicationid")
    public BaseResponse<Eudeclarationofconformity> findEudeclarationofconformitybyapplicationid(String applicationid){
        Eudeclarationofconformity eudeclarationofconformity = eudeclarationofconformityService.findEudeclarationofconformitybyapplicationid(applicationid);
        return ResultUtils.success(eudeclarationofconformity);
    }
    @GetMapping("/Eudeclarationofconformity/pageList")
    public BaseResponse<Page<Eudeclarationofconformity>> findAllEudeclarationofconformitys(long pageSize, long pageNum){
        QueryWrapper<Eudeclarationofconformity> queryWrapper = new QueryWrapper<>();
        Page<Eudeclarationofconformity> eudeclarationofconformityPage = eudeclarationofconformityService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return ResultUtils.success(eudeclarationofconformityPage);
    }
    @PostMapping("/Eudeclarationofconformity/add")
    public BaseResponse<Integer> addEudeclarationofconformitys(@RequestBody Eudeclarationofconformity eud){
        return ResultUtils.success(eudeclarationofconformityService.addEudeclarationofconformity(eud));
    }
    @PostMapping("/Eudeclarationofconformity/update")
    public BaseResponse<Integer> updateEudeclarationofconformity(@RequestBody Eudeclarationofconformity eud){
        if (eud == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return ResultUtils.success(eudeclarationofconformityService.updateEudeclarationofconformity(eud));
    }
    @DeleteMapping("/Eudeclarationofconformity/delete/{declarationid}")
    public int deleteEudeclarationofconformity(@PathVariable int declarationid){
        return eudeclarationofconformityService.deleteEudeclarationofconformity(declarationid);
    }
    @PostMapping("/Eudeclarationofconformity/addAndGenerate")
    public ResponseEntity<?> addAndGenerateEudeclarationofconformity(@RequestBody Eudeclarationofconformity eud) {
        int declarationId = eudeclarationofconformityService.addEudeclarationofconformity(eud);

        // 生成 Word 文档
        byte[] wordDocument = eudeclarationofconformityService.generateWordDocument(declarationId);

        // 设置响应头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename("declaration.docx").build());
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        return ResponseEntity.ok()
                .headers(headers)
                .body(wordDocument);
    }
}
