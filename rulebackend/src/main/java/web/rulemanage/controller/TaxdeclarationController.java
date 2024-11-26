package web.rulemanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import web.rulemanage.common.BaseResponse;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.common.ResultUtils;
import web.rulemanage.domain.Taxdeclaration;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.service.TaxdeclarationService;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://127.0.0.1:5173",allowCredentials = "true")
public class TaxdeclarationController {
    @Resource
    private TaxdeclarationService taxdeclarationService;
    @GetMapping("/Taxdeclaration/find")
    public BaseResponse<Taxdeclaration> findTaxdeclaration(String declarationid){
        Taxdeclaration taxdeclaration = taxdeclarationService.findTaxdeclaration(declarationid);
        return ResultUtils.success(taxdeclaration);
    }
    @GetMapping("/Taxdeclaration/find1")
    public BaseResponse<Taxdeclaration> findTaxdeclarationbysearchbyvatnumber(String searchbyvatnumber){
        Taxdeclaration taxdeclaration = taxdeclarationService.findTaxdeclarationbysearchbyvatnumber(searchbyvatnumber);
        return ResultUtils.success(taxdeclaration);
    }
    @GetMapping("/Taxdeclaration/find2")
    public BaseResponse<Taxdeclaration> findTaxdeclarationbyvatnumber(String vatnumber){
        Taxdeclaration taxdeclaration = taxdeclarationService.findTaxdeclarationbyvatnumber(vatnumber);
        return ResultUtils.success(taxdeclaration);
    }
    @GetMapping("/Taxdeclaration/pageList")
    public BaseResponse<Page<Taxdeclaration>> findAllTaxdeclaration(long pageSize, long pageNum){
        QueryWrapper<Taxdeclaration> queryWrapper = new QueryWrapper<>();
        Page<Taxdeclaration> taxdeclarationPage = taxdeclarationService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return ResultUtils.success(taxdeclarationPage);
    }
    @PostMapping("/Taxdeclaration/add")
    public BaseResponse<Integer> addTaxdeclaration(@RequestBody Taxdeclaration tax){
        return ResultUtils.success(taxdeclarationService.addTaxdeclaration(tax));
    }

    @DeleteMapping("/Taxdeclaration/delete/{declarationid}")
    public int deleteTaxdeclaration(@PathVariable int declarationid){
        return taxdeclarationService.deleteTaxdeclaration(declarationid);
    }
}
