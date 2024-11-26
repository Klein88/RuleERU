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
import web.rulemanage.domain.Importbyyuancailiao;
import web.rulemanage.service.ImportbyfoodService;
import web.rulemanage.service.ImportbyyuancailiaoService;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://127.0.0.1:5173",allowCredentials = "true")
public class ImportbyyuancailiaoController {
    @Resource
    private ImportbyyuancailiaoService importbyyuancailiaoService;

    @GetMapping("/Importbyyuancailiao/find")
    public BaseResponse<Importbyyuancailiao> findImportbyyuancailiao(String id){
        Importbyyuancailiao importbyyuancailiao = importbyyuancailiaoService.findImportbyyuancailiao(id);
        return ResultUtils.success(importbyyuancailiao);
    }
    @GetMapping("/Importbyyuancailiao/pageList")
    public BaseResponse<Page<Importbyyuancailiao>> findAllImportbyyuancailiao(long pageSize, long pageNum){
        QueryWrapper<Importbyyuancailiao> queryWrapper = new QueryWrapper<>();
        Page<Importbyyuancailiao> importbyyuancailiaoPage = importbyyuancailiaoService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return ResultUtils.success(importbyyuancailiaoPage);
    }
}
