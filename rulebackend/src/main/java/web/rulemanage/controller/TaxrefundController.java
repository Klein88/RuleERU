package web.rulemanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import web.rulemanage.common.BaseResponse;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.common.ResultUtils;
import web.rulemanage.domain.Taxpayment;
import web.rulemanage.domain.Taxrefund;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.service.TaxpaymentService;
import web.rulemanage.service.TaxrefundService;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://127.0.0.1:5173",allowCredentials = "true")
public class TaxrefundController {
    @Resource
    private TaxrefundService taxrefundService;
    @GetMapping("/Taxrefund/findbyid")
    public BaseResponse<Taxrefund> findTaxrefundbyid(String taxrefundid){
        Taxrefund taxrefund = taxrefundService.findTaxrefundbyid(taxrefundid);
        return ResultUtils.success(taxrefund);
    }
    @GetMapping("/Taxrefund/findbycountry")
    public BaseResponse<List<Taxrefund>> findTaxrefundBycountry(String country) {
        List<Taxrefund> taxrefunds = taxrefundService.findTaxrefundByCountry(country);
        return ResultUtils.success(taxrefunds);
    }

    @GetMapping("/Taxrefund/findbyvatnumber")
    public BaseResponse<Taxrefund> findTaxrefundbyvatnumber(String vatnumber){
        Taxrefund taxrefund = taxrefundService.findTaxrefundbyvatnumber(vatnumber);
        return ResultUtils.success(taxrefund);
    }
    @GetMapping("/Taxrefund/findbystatus")
    public BaseResponse<List<Taxrefund>> findTaxrefundbyOperation(String operation){
        List<Taxrefund> taxrefund = taxrefundService.findTaxrefundbyOperation(operation);
        return ResultUtils.success(taxrefund);
    }
    @GetMapping("/Taxrefund/pageList")
    public BaseResponse<Page<Taxrefund>> findAllTaxtrfund(long pageSize, long pageNum){
        QueryWrapper<Taxrefund> queryWrapper = new QueryWrapper<>();
        Page<Taxrefund> taxrefundPage = taxrefundService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return ResultUtils.success(taxrefundPage);
    }
    @PostMapping("/Taxrefund/add")
    public BaseResponse<Integer> addTaxrefund(@RequestBody Taxrefund tax){
        return ResultUtils.success(taxrefundService.addTaxrefund(tax));
    }
    @PostMapping("/Taxrefund/update")
    public BaseResponse<Integer> updateTaxrefund(@RequestBody Taxrefund tax){
        if (tax == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return ResultUtils.success(taxrefundService.updateTaxrefund(tax));
    }
    @DeleteMapping("/Taxrefund/delete/{taxrefundid}")
    public int deleteTaxrefund(@PathVariable int taxrefundid){
        return taxrefundService.deleteTaxrefund(taxrefundid);
    }
}
