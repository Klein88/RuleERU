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
import web.rulemanage.domain.Importbyhuaxuepin;
import web.rulemanage.service.ImportbyfoodService;
import web.rulemanage.service.ImportbyhuaxuepinService;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://127.0.0.1:5173",allowCredentials = "true")
public class ImportbyhuaxuepinController {
    @Resource
    private ImportbyhuaxuepinService importbyhuaxuepinService;

    @GetMapping("/Importbyhuaxuepin/find")
    public BaseResponse<Importbyhuaxuepin> findImportbyhuaxuepin(String id){
        Importbyhuaxuepin importbyhuaxuepin = importbyhuaxuepinService.findImportbyhuaxuepin(id);
        return ResultUtils.success(importbyhuaxuepin);
    }
    @GetMapping("/Importbyhuaxuepin/pageList")
    public BaseResponse<Page<Importbyhuaxuepin>> findAllImportbyhuaxuepin(long pageSize, long pageNum){
        QueryWrapper<Importbyhuaxuepin> queryWrapper = new QueryWrapper<>();
        Page<Importbyhuaxuepin> importbyhuaxuepinPage = importbyhuaxuepinService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return ResultUtils.success(importbyhuaxuepinPage);
    }
}
