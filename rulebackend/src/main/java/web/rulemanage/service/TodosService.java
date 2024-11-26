package web.rulemanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;
import web.rulemanage.domain.Todos;

/**
* @author xpc
* @description 针对表【ToDos】的数据库操作Service
* @createDate 2023-10-11 14:00:32
*/
public interface TodosService extends IService<Todos> {
    @Transactional
    public int addTodos(Todos todos);
    @Transactional
    Todos findTodos(String ToDoID);
    @Transactional
    int updateTodos(Todos todos);
    @Transactional
    public int deleteTodos(int ToDoID);
}
