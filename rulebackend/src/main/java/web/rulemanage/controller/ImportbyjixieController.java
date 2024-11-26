package web.rulemanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.rulemanage.common.BaseResponse;
import web.rulemanage.common.ResultUtils;
import web.rulemanage.domain.Importbyfood;
import web.rulemanage.domain.Importbyjixie;
import web.rulemanage.service.ImportbyfoodService;
import web.rulemanage.service.ImportbyjixieService;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://127.0.0.1:5173",allowCredentials = "true")
public class ImportbyjixieController {
    @Resource
    private ImportbyjixieService importbyjixieService;

    @GetMapping("/Importbyjixie/find")
    public BaseResponse<Importbyjixie> findImportbyjixie(String id){
        Importbyjixie importbyjixie = importbyjixieService.findImportbyjixie(id);
        return ResultUtils.success(importbyjixie);
    }
    @GetMapping("/Importbyjixie/pageList")
    public BaseResponse<Page<Importbyjixie>> findAllImportbyjixie(long pageSize, long pageNum){
        QueryWrapper<Importbyjixie> queryWrapper = new QueryWrapper<>();
        Page<Importbyjixie> importbyjixiePage = importbyjixieService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return ResultUtils.success(importbyjixiePage);
    }
}
