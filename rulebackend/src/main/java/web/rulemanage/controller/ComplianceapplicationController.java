package web.rulemanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import web.rulemanage.common.BaseResponse;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.common.ResultUtils;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Complianceapplication;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.service.ComplianceapplicationService;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://127.0.0.1:5173",allowCredentials = "true")
public class ComplianceapplicationController {
    @Resource
    private ComplianceapplicationService complianceapplicationService;
    @GetMapping("/Complianceapplication/find")
    public BaseResponse<Complianceapplication> findComplianceapplication(String applicationid){
        Complianceapplication complianceapplication = complianceapplicationService.findComplianceapplication(applicationid);
        return ResultUtils.success(complianceapplication);
    }
    @GetMapping("/Complianceapplication/pageList")
    public BaseResponse<Page<Complianceapplication>> findAllComplianceapplication(long pageSize, long pageNum){
        QueryWrapper<Complianceapplication> queryWrapper = new QueryWrapper<>();
        Page<Complianceapplication> complianceapplicationPage = complianceapplicationService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return ResultUtils.success(complianceapplicationPage);
    }
    @PostMapping("/Complianceapplication/add")
    public BaseResponse<Integer> addComplianceapplication(@RequestBody Complianceapplication com){
        return ResultUtils.success(complianceapplicationService.addComplianceapplication(com));
    }
    @DeleteMapping("/Complianceapplication/delete/{applicationid}")
    public int deleteComplianceapplication(@PathVariable int applicationid){
        return complianceapplicationService.deleteComplianceapplication(applicationid);
    }
}
