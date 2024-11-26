package web.rulemanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import web.rulemanage.common.BaseResponse;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.common.ResultUtils;
import web.rulemanage.domain.Vatdeclarationdetails;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.service.VatdeclarationdetailsService;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://127.0.0.1:5173",allowCredentials = "true")
public class VatdeclarationdetailsController {
    @Resource
    private VatdeclarationdetailsService vatdeclarationdetailsService;
    @GetMapping("/Vatdeclarationdetails/find")
    public BaseResponse<Vatdeclarationdetails> findVatdeclarationdetails(String declarationdetailid){
        Vatdeclarationdetails vatdeclarationdetails = vatdeclarationdetailsService.findVatdeclarationdetails(declarationdetailid);
        return ResultUtils.success(vatdeclarationdetails);
    }
    @GetMapping("/Vatdeclarationdetails/pageList")
    public BaseResponse<Page<Vatdeclarationdetails>> findAllVatdeclarationdetails(long pageSize, long pageNum){
        QueryWrapper<Vatdeclarationdetails> queryWrapper = new QueryWrapper<>();
        Page<Vatdeclarationdetails> vatdeclarationdetailsPage = vatdeclarationdetailsService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return ResultUtils.success(vatdeclarationdetailsPage);
    }
    @PostMapping("/Vatdeclarationdetails/add")
    public BaseResponse<Integer> addVatdeclarationdetails(@RequestBody Vatdeclarationdetails vat){
        return ResultUtils.success(vatdeclarationdetailsService.addVatdeclarationdetails(vat));
    }
    @DeleteMapping("/Vatdeclarationdetails/delete/{declarationdetailid}")
    public int deleteVatdeclarationdetails(@PathVariable int declarationdetailid){
        return vatdeclarationdetailsService.deleteVatdeclarationdetails(declarationdetailid);
    }
}
