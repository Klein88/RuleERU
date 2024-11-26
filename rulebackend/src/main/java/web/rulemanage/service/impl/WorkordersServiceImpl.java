package web.rulemanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Workorders;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.mapper.WorkordersMapper;
import web.rulemanage.service.WorkordersService;

/**
* @author xpc
* @description 针对表【WorkOrders】的数据库操作Service实现
* @createDate 2023-10-11 14:00:32
*/
@Service
public class WorkordersServiceImpl extends ServiceImpl<WorkordersMapper, Workorders>
    implements WorkordersService{

    @Resource
    private WorkordersMapper workordersMapper;

    @Override
    public int addWorkorders(Workorders workorders) {
        if (workorders == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return workordersMapper.insert(workorders);
    }

    @Override
    public Workorders findWorkorders(String WorkOrderID) {
        QueryWrapper<Workorders> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(WorkOrderID)) {
            queryWrapper.eq("WorkOrderID", WorkOrderID);
        }
        return workordersMapper.selectOne(queryWrapper);
    }

    @Override
    public int updateWorkorders(Workorders workorders) {
        if (workorders == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return workordersMapper.updateById(workorders);
    }
}




