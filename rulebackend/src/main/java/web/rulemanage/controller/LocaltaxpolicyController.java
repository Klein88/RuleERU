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
import web.rulemanage.domain.Localtaxpolicy;
import web.rulemanage.service.LocaltaxpolicyService;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://127.0.0.1:5173",allowCredentials = "true")
public class LocaltaxpolicyController {
    @Resource
    private LocaltaxpolicyService localtaxpolicyService;

    @GetMapping("/Localtaxpolicy/find")
    public BaseResponse<Localtaxpolicy> findLocaltaxpolicyService(String taxpolicydescription){
        Localtaxpolicy localtaxpolicy = localtaxpolicyService.findLocaltaxpolicy(taxpolicydescription);
        return ResultUtils.success(localtaxpolicy);
    }
    @GetMapping("/Localtaxpolicy/pageList")
    public BaseResponse<Page<Localtaxpolicy>> findAllVatdeclarationdetails(long pageSize, long pageNum){
        QueryWrapper<Localtaxpolicy> queryWrapper = new QueryWrapper<>();
        Page<Localtaxpolicy> localtaxpolicyPage = localtaxpolicyService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return ResultUtils.success(localtaxpolicyPage);
    }
}
