package web.rulemanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import web.rulemanage.common.BaseResponse;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.common.ResultUtils;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Packagingsummarydeclaration;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.service.CompaniesService;
import web.rulemanage.service.PackagingsummarydeclarationService;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://127.0.0.1:5173",allowCredentials = "true")
public class PackagingsummarydeclarationController {
    @Resource
    private PackagingsummarydeclarationService packagingsummarydeclarationService;

    @GetMapping("/Packagingsummarydeclaration/find")
    public BaseResponse<List<Packagingsummarydeclaration>> findPackagingsummarydeclaration(String eprdeclarationid){
        List<Packagingsummarydeclaration> packagingsummarydeclaration = packagingsummarydeclarationService.findPackagingsummarydeclaration(eprdeclarationid);
        return ResultUtils.success(packagingsummarydeclaration);
    }
    @GetMapping("/Packagingsummarydeclaration/pageList")
    public BaseResponse<Page<Packagingsummarydeclaration>> findAllPackagingsummarydeclaration(long pageSize, long pageNum){
        QueryWrapper<Packagingsummarydeclaration> queryWrapper = new QueryWrapper<>();
        Page<Packagingsummarydeclaration> packagingsummarydeclarationPage = packagingsummarydeclarationService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return ResultUtils.success(packagingsummarydeclarationPage);
    }
    @PostMapping("/Packagingsummarydeclaration/add")
    public BaseResponse<Integer> addPackagingsummarydeclaration(@RequestBody Packagingsummarydeclaration pack){
        return ResultUtils.success(packagingsummarydeclarationService.addPackagingsummarydeclaration(pack));
    }
    @PostMapping("/Packagingsummarydeclaration/update")
    public BaseResponse<Integer> updatePackagingsummarydeclaration(@RequestBody Packagingsummarydeclaration pack){
        if (pack == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return ResultUtils.success(packagingsummarydeclarationService.updatePackagingsummarydeclaration(pack));
    }
    @DeleteMapping("/Packagingsummarydeclaration/delete/{declarationid}")
    public int deletePackagingsummarydeclaration(@PathVariable int declarationid){
        return packagingsummarydeclarationService.deletePackagingsummarydeclaration(declarationid);
    }
}
