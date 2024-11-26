package web.rulemanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import web.rulemanage.common.BaseResponse;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.common.ResultUtils;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Taxservice;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.service.CompaniesService;
import web.rulemanage.service.TaxserviceService;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://127.0.0.1:5173",allowCredentials = "true")
public class TaxserviceController {
    @Resource
    private TaxserviceService taxserviceService;
    @GetMapping("/Taxservice/find")
    public BaseResponse<Taxservice> findTaxservice(String taxserviceid){
        Taxservice taxservice = taxserviceService.findTaxservice(taxserviceid);
        return ResultUtils.success(taxservice);
    }
    @GetMapping("/Taxservice/findbyvatnumber")
    public BaseResponse<Taxservice> findTaxservicebyvatnumber(String vatnumber){
        Taxservice taxservice = taxserviceService.findTaxservicebyvatnumber(vatnumber);
        return ResultUtils.success(taxservice);
    }
    @GetMapping("/Taxservice/pageList")
    public BaseResponse<Page<Taxservice>> findAllTaxservice(long pageSize, long pageNum){
        QueryWrapper<Taxservice> queryWrapper = new QueryWrapper<>();
        Page<Taxservice> taxservicePage = taxserviceService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return ResultUtils.success(taxservicePage);
    }
    @PostMapping("/Taxservice/add")
    public BaseResponse<Integer> addTaxservice(@RequestBody Taxservice tax){
        return ResultUtils.success(taxserviceService.addTaxservice(tax));
    }
    @PostMapping("/Taxservice/update")
    public BaseResponse<Integer> updateTaxservice(@RequestBody Taxservice tax){
        if (tax == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return ResultUtils.success(taxserviceService.updateTaxservice(tax));
    }
}
