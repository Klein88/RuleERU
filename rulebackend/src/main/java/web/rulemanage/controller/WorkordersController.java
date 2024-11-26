package web.rulemanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import web.rulemanage.common.BaseResponse;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.common.ResultUtils;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Workorders;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.service.WorkordersService;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://127.0.0.1:5173",allowCredentials = "true")
public class WorkordersController {
    @Resource
    private WorkordersService workordersService;

    @GetMapping("/Workorder/find")
    public BaseResponse<Workorders> findWorkorder(String workorderid){
        Workorders workorders = workordersService.findWorkorders(workorderid);
        return ResultUtils.success(workorders);
    }
    @GetMapping("/Workorder/pageList")
    public BaseResponse<Page<Workorders>> findAllWorkorder(long pageSize, long pageNum){
        QueryWrapper<Workorders> queryWrapper = new QueryWrapper<>();
        Page<Workorders> workordersPage = workordersService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return ResultUtils.success(workordersPage);
    }
    @PostMapping("/Workorder/add")
    public BaseResponse<Integer> addWorkorders(@RequestBody Workorders workorders){
        return ResultUtils.success(workordersService.addWorkorders(workorders));
    }
    @PostMapping("/Workorder/update")
    public BaseResponse<Integer> updateWorkorders(@RequestBody Workorders wok){
        if (wok == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return ResultUtils.success(workordersService.updateWorkorders(wok));
    }

}
