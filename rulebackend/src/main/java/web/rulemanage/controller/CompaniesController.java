package web.rulemanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import web.rulemanage.common.BaseResponse;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.common.ResultUtils;
import web.rulemanage.domain.Companies;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.service.CompaniesService;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://127.0.0.1:5173",allowCredentials = "true")
public class CompaniesController {
    @Resource
    private CompaniesService companiesService;

    @GetMapping("/Companies/find")
    public BaseResponse<Companies> findCompanies(String companyid){
        Companies companies = companiesService.findCompanies(companyid);
        return ResultUtils.success(companies);
    }
    @GetMapping("/Companies/pageList")
    public BaseResponse<Page<Companies>> findAllCompanies(long pageSize,long pageNum){
        QueryWrapper<Companies> queryWrapper = new QueryWrapper<>();
        Page<Companies> companiesPage = companiesService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return ResultUtils.success(companiesPage);
    }
    @PostMapping("/Companies/add")
    public BaseResponse<Integer> addCompanies(@RequestBody Companies com){
        return ResultUtils.success(companiesService.addCompanies(com));
    }
    @PostMapping("/Companies/update")
    public BaseResponse<Integer> updateCompanies(@RequestBody Companies com){
        if (com == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return ResultUtils.success(companiesService.updateCompanies(com));
    }
    @DeleteMapping("/Companies/delete/{companyid}")
    public int deleteCompanies(@PathVariable int companyid){
        return companiesService.deleteCompanies(companyid);
    }
//    121.40.119.233
}
