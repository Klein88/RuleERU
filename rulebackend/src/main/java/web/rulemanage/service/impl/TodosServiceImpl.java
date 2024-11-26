package web.rulemanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.domain.Todos;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.mapper.TodosMapper;
import web.rulemanage.service.TodosService;

/**
* @author xpc
* @description 针对表【ToDos】的数据库操作Service实现
* @createDate 2023-10-11 14:00:32
*/
@Service
public class TodosServiceImpl extends ServiceImpl<TodosMapper, Todos>
    implements TodosService{
    @Resource
    private TodosMapper todosMapper;
    @Override
    public int addTodos(Todos todos) {
        if (todos == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return todosMapper.insert(todos);
    }
    @Override
    public Todos findTodos(String ToDoID) {
        QueryWrapper<Todos> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(ToDoID)) {
            queryWrapper.eq("ToDoID", ToDoID);
        }
        return todosMapper.selectOne(queryWrapper);
    }
    @Override
    public int updateTodos(Todos todos) {
        if (todos == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return todosMapper.updateById(todos);
    }
    @Override
    public int deleteTodos(int ToDoID) {
        if (ToDoID <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return todosMapper.deleteById(ToDoID);
    }
}




