package web.rulemanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import web.rulemanage.common.BaseResponse;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.common.ResultUtils;
import web.rulemanage.domain.Companyinfo;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.service.CompanyinfoService;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://127.0.0.1:5173",allowCredentials = "true")
public class CompanyinfoController {
    @Resource
    private CompanyinfoService companyinfoService;
    @GetMapping("/Companyinfo/find")
    public BaseResponse<Companyinfo> findCompanyinfo(String companyname){
        Companyinfo companyinfo = companyinfoService.findCompanyinfo(companyname);
        return ResultUtils.success(companyinfo);
    }
    @GetMapping("/Companyinfo/pageList")
    public BaseResponse<Page<Companyinfo>> findAllCompanyinfo(long pageSize, long pageNum){
        QueryWrapper<Companyinfo> queryWrapper = new QueryWrapper<>();
        Page<Companyinfo> companyinfoPage = companyinfoService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return ResultUtils.success(companyinfoPage);
    }
    @PostMapping("/Companyinfo/update")
    public BaseResponse<Integer> updateCompanyinfo(@RequestBody Companyinfo cominfo){
        if (cominfo == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return ResultUtils.success(companyinfoService.updateCompanyinfo(cominfo));
    }

}
