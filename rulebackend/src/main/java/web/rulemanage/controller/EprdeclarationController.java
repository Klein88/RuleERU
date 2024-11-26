package web.rulemanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import web.rulemanage.common.BaseResponse;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.common.ResultUtils;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Eprdeclaration;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.service.CompaniesService;
import web.rulemanage.service.EprdeclarationService;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://127.0.0.1:5173",allowCredentials = "true")
public class EprdeclarationController {
    @Resource
    private EprdeclarationService eprdeclarationService;

    @GetMapping("/Eprdeclaration/find")
    public BaseResponse<Eprdeclaration> findEprdeclaration(String declarationid){
        Eprdeclaration eprdeclaration = eprdeclarationService.findEprdeclaration(declarationid);
        return ResultUtils.success(eprdeclaration);
    }
    @GetMapping("/Eprdeclaration/pageList")
    public BaseResponse<Page<Eprdeclaration>> findAllEprdeclaration(long pageSize, long pageNum){
        QueryWrapper<Eprdeclaration> queryWrapper = new QueryWrapper<>();
        Page<Eprdeclaration> eprdeclarationPage = eprdeclarationService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return ResultUtils.success(eprdeclarationPage);
    }
    @PostMapping("/Eprdeclaration/add")
    public BaseResponse<Integer> addEprdeclaration(@RequestBody Eprdeclaration epr){
        return ResultUtils.success(eprdeclarationService.addEprdeclaration(epr));
    }
    @PostMapping("/Eprdeclaration/update")
    public BaseResponse<Integer> updateEprdeclaration(@RequestBody Eprdeclaration epr){
        if (epr == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return ResultUtils.success(eprdeclarationService.updateEprdeclaration(epr));
    }

    @DeleteMapping("/Eprdeclaration/delete/{declarationid}")
    public int deleteEprdeclaration(@PathVariable int declarationid){
        return eprdeclarationService.deleteEprdeclaration(declarationid);
    }
}
