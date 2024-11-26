package web.rulemanage.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import web.rulemanage.common.BaseResponse;
import web.rulemanage.common.ResultUtils;
import web.rulemanage.domain.Taxpayment;
import web.rulemanage.domain.Taxpaymentnext;
import web.rulemanage.service.TaxpaymentService;
import web.rulemanage.service.TaxpaymentnextService;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://127.0.0.1:5173",allowCredentials = "true")
public class TaxpaymentnextController {
    @Resource
    private TaxpaymentnextService taxpaymentnextService;
    @PostMapping("/Taxpaymentnext/add")
    public BaseResponse<Integer> addTaxpaymentnext(@RequestBody Taxpaymentnext tax){
        return ResultUtils.success(taxpaymentnextService.addTaxpaymentnext(tax));
    }
    @GetMapping("/Taxpaymentnext/findbyid")
    public BaseResponse<Taxpaymentnext> findTaxpaymentnext(String taxpaymentnextid){
        Taxpaymentnext taxpaymentnext = taxpaymentnextService.findTaxpaymentnext(taxpaymentnextid);
        return ResultUtils.success(taxpaymentnext);
    }

}
