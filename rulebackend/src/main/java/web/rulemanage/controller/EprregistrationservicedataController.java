package web.rulemanage.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import web.rulemanage.common.BaseResponse;
import web.rulemanage.common.ResultUtils;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Eprregistrationservicedata;
import web.rulemanage.mapper.EprregistrationservicedataMapper;
import web.rulemanage.service.CompaniesService;
import web.rulemanage.service.EprregistrationservicedataService;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://127.0.0.1:5173",allowCredentials = "true")
public class EprregistrationservicedataController {
    @Resource
    private EprregistrationservicedataService eprregistrationservicedataService;

    @PostMapping("/Eprregistrationservicedata/add")
    public BaseResponse<Integer> addEprregistrationservicedata(@RequestBody Eprregistrationservicedata epr){
        return ResultUtils.success(eprregistrationservicedataService.addEprregistrationservicedata(epr));
    }
}
