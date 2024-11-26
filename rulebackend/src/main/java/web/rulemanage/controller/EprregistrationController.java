package web.rulemanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import web.rulemanage.common.BaseResponse;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.common.ResultUtils;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Eprregistration;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.service.EprregistrationService;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://127.0.0.1:5173",allowCredentials = "true")
public class EprregistrationController {
    //这个是EPR首页那个表
    @Resource
    private EprregistrationService eprregistrationService;

    @GetMapping("/Eprregistration/find")
    public BaseResponse<Eprregistration> findEprregistration(String registrationid){
        Eprregistration eprregistration = eprregistrationService.findEprregistration(registrationid);
        return ResultUtils.success(eprregistration);
    }
    @GetMapping("/Eprregistration/pageList")
    public BaseResponse<Page<Eprregistration>> findAllEprregistration(long pageSize, long pageNum){
        QueryWrapper<Eprregistration> queryWrapper = new QueryWrapper<>();
        Page<Eprregistration> eprregistrationPage = eprregistrationService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return ResultUtils.success(eprregistrationPage);
    }
    @PostMapping("/Eprregistration/add")
    public BaseResponse<Integer> addEprregistration(@RequestBody Eprregistration epr){
        return ResultUtils.success(eprregistrationService.addEprregistration(epr));
    }
    @PostMapping("/Eprregistration/update")
    public BaseResponse<Integer> updateEprregistration(@RequestBody Eprregistration epr){
        if (epr == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return ResultUtils.success(eprregistrationService.updateEprregistration(epr));
    }
    @DeleteMapping("/Eprregistration/delete/{registrationid}")
    public int deleteEprregistration(@PathVariable int registrationid){
        return eprregistrationService.deleteEprregistration(registrationid);
    }
}
