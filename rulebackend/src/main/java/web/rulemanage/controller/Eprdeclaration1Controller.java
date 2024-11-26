package web.rulemanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import web.rulemanage.common.BaseResponse;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.common.ResultUtils;
import web.rulemanage.domain.Eprdeclaration;
import web.rulemanage.domain.Eprdeclaration1;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.service.Eprdeclaration1Service;
import web.rulemanage.service.EprdeclarationService;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://127.0.0.1:5173",allowCredentials = "true")
public class Eprdeclaration1Controller {
    @Resource
    private Eprdeclaration1Service eprdeclaration1Service;
    @GetMapping("/Eprdeclaration1/find")
    public BaseResponse<Eprdeclaration1> findEprdeclaration1(String declarationid){
        Eprdeclaration1 eprdeclaration1 = eprdeclaration1Service.findEprdeclaration1(declarationid);
        return ResultUtils.success(eprdeclaration1);
    }
    @GetMapping("/Eprdeclaration1/findbyid")
    public BaseResponse<Eprdeclaration1> findEprdeclaration1byid(String registrationnumber){
        Eprdeclaration1 eprdeclaration1 = eprdeclaration1Service.findEprdeclaration1byid(registrationnumber);
        return ResultUtils.success(eprdeclaration1);
    }
    @GetMapping("/Eprdeclaration1/pageList")
    public BaseResponse<Page<Eprdeclaration1>> findAllEprdeclaration1(long pageSize, long pageNum){
        QueryWrapper<Eprdeclaration1> queryWrapper = new QueryWrapper<>();
        Page<Eprdeclaration1> eprdeclaration1Page = eprdeclaration1Service.page(new Page<>(pageNum, pageSize), queryWrapper);
        return ResultUtils.success(eprdeclaration1Page);
    }
    @PostMapping("/Eprdeclaration1/add")
    public BaseResponse<Integer> addEprdeclaration1(@RequestBody Eprdeclaration1 epr){
        return ResultUtils.success(eprdeclaration1Service.addEprdeclaration1(epr));
    }
    @PostMapping("/Eprdeclaration1/update")
    public BaseResponse<Integer> updateEprdeclaration1(@RequestBody Eprdeclaration1 epr){
        if (epr == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return ResultUtils.success(eprdeclaration1Service.updateEprdeclaration1(epr));
    }

    @DeleteMapping("/Eprdeclaration1/delete/{declarationid}")
    public int deleteEprdeclaration1(@PathVariable int declarationid){
        return eprdeclaration1Service.deleteEprdeclaration1(declarationid);
    }
}
