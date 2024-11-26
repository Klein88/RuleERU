package web.rulemanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import web.rulemanage.common.BaseResponse;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.common.ResultUtils;
import web.rulemanage.domain.Eprservice;
import web.rulemanage.domain.Taxservice;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.service.EprserviceService;
import web.rulemanage.service.TaxserviceService;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://127.0.0.1:5173",allowCredentials = "true")
public class EprserviceController {
    @Resource
    private EprserviceService eprserviceService;

    @GetMapping("/Eprservice/find")
    public BaseResponse<Eprservice> findEprservice(String eprserviceid){
        Eprservice eprservice = eprserviceService.findEprservice(eprserviceid);
        return ResultUtils.success(eprservice);
    }
    @GetMapping("/Eprservice/pageList")
    public BaseResponse<Page<Eprservice>> findAllEprservice(long pageSize, long pageNum){
        QueryWrapper<Eprservice> queryWrapper = new QueryWrapper<>();
        Page<Eprservice> eprservicePage = eprserviceService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return ResultUtils.success(eprservicePage);
    }
    @PostMapping("/Eprservice/add")
    public BaseResponse<Integer> addEprservice(@RequestBody Eprservice epr){
        return ResultUtils.success(eprserviceService.addEprservice(epr));
    }
    @PostMapping("/Eprservice/update")
    public BaseResponse<Integer> updateEprservice(@RequestBody Eprservice epr){
        if (epr == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return ResultUtils.success(eprserviceService.updateEprservice(epr));
    }
}
