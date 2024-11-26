package web.rulemanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;
import web.rulemanage.domain.Companies;
import web.rulemanage.domain.Workorders;

/**
* @author xpc
* @description 针对表【WorkOrders】的数据库操作Service
* @createDate 2023-10-11 14:00:32
*/
public interface WorkordersService extends IService<Workorders> {
    @Transactional
    public int addWorkorders(Workorders workorders);
    @Transactional
    Workorders findWorkorders(String WorkOrderID);
    @Transactional
    int updateWorkorders(Workorders workorders);
}
