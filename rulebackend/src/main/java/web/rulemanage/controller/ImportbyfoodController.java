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
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Importbyfood;
import web.rulemanage.service.CompaniesService;
import web.rulemanage.service.ImportbyfoodService;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://127.0.0.1:5173",allowCredentials = "true")
public class ImportbyfoodController {
    @Resource
    private ImportbyfoodService importbyfoodService;

    @GetMapping("/Importbyfood/find")
    public BaseResponse<Importbyfood> findImportbyfood(String id){
        Importbyfood importbyfood = importbyfoodService.findImportbyfood(id);
        return ResultUtils.success(importbyfood);
    }
    @GetMapping("/Importbyfood/pageList")
    public BaseResponse<Page<Importbyfood>> findAllImportbyfood(long pageSize, long pageNum){
        QueryWrapper<Importbyfood> queryWrapper = new QueryWrapper<>();
        Page<Importbyfood> importbyfoodPage = importbyfoodService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return ResultUtils.success(importbyfoodPage);
    }
}
