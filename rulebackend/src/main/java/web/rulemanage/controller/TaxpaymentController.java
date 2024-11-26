package web.rulemanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import web.rulemanage.common.BaseResponse;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.common.ResultUtils;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Taxpayment;
import web.rulemanage.domain.Taxrefund;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.service.TaxpaymentService;
import web.rulemanage.service.TaxserviceService;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://127.0.0.1:5173",allowCredentials = "true")
public class TaxpaymentController {
    @Resource
    private TaxpaymentService taxpaymentService;
    @GetMapping("/Taxpayment/findbyid")
    public BaseResponse<Taxpayment> findTaxpaymentbyid(String taxpaymentid){
        Taxpayment taxpayment = taxpaymentService.findTaxpaymentbyid(taxpaymentid);
        return ResultUtils.success(taxpayment);
    }
    @GetMapping("/Taxpayment/findbycompanyname")
    public BaseResponse<List<Taxpayment>> findTaxpaymentbycompanyname(String companyname){
        List<Taxpayment> taxpayment = taxpaymentService.findTaxpaymentbycompanyname(companyname);
        return ResultUtils.success(taxpayment);
    }
    @GetMapping("/Taxpayment/findbystatus")
    public BaseResponse<List<Taxpayment>> findTaxpaymentbyPaymentStatus(String paymentstatus){
        List<Taxpayment> taxpayment = taxpaymentService.findTaxpaymentbyPaymentStatus(paymentstatus);
        return ResultUtils.success(taxpayment);
    }
    @GetMapping("/Taxpayment/pageList")
    public BaseResponse<Page<Taxpayment>> findAllTaxpayment(long pageSize, long pageNum){
        QueryWrapper<Taxpayment> queryWrapper = new QueryWrapper<>();
        Page<Taxpayment> taxpaymentPage = taxpaymentService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return ResultUtils.success(taxpaymentPage);
    }
    @PostMapping("/Taxpayment/add")
    public BaseResponse<Integer> addTaxpayment(@RequestBody Taxpayment tax){
        return ResultUtils.success(taxpaymentService.addTaxpayment(tax));
    }
    @PostMapping("/Taxpayment/update")
    public BaseResponse<Integer> updateTaxpayment(@RequestBody Taxpayment tax){
        if (tax == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return ResultUtils.success(taxpaymentService.updateTaxpayment(tax));
    }
    @DeleteMapping("/Taxpayment/delete/{taxpaymentid}")
    public int deleteTaxpayment(@PathVariable int taxpaymentid){
        return taxpaymentService.deleteTaxpayment(taxpaymentid);
    }
//    121.40.119.233
}
