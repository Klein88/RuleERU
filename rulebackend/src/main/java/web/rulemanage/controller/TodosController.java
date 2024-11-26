package web.rulemanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import web.rulemanage.common.BaseResponse;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.common.ResultUtils;
import web.rulemanage.domain.Todos;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.service.TodosService;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://127.0.0.1:5173",allowCredentials = "true")
public class TodosController {
    @Resource
    private TodosService todosService;

    @GetMapping("/Todos/find")
    public BaseResponse<Todos> findTodos(String todoid){
        Todos todos = todosService.findTodos(todoid);
        return ResultUtils.success(todos);
    }
    @GetMapping("/Todos/pageList")
    public BaseResponse<Page<Todos>> findAllTodos(long pageSize, long pageNum){
        QueryWrapper<Todos> queryWrapper = new QueryWrapper<>();
        Page<Todos> todosPage = todosService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return ResultUtils.success(todosPage);
    }
    @PostMapping("/Todos/add")
    public BaseResponse<Integer> addTodos(@RequestBody Todos todo){
        return ResultUtils.success(todosService.addTodos(todo));
    }
    @PostMapping("/Todos/update")
    public BaseResponse<Integer> updateTodos(@RequestBody Todos todo){
        if (todo == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return ResultUtils.success(todosService.updateTodos(todo));
    }

    @DeleteMapping("/Todos/delete/{todoid}")
    public int deleteTodos(@PathVariable int todoid){
        return todosService.deleteTodos(todoid);
    }
}
