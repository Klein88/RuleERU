package web.rulemanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import web.rulemanage.common.BaseResponse;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.common.ResultUtils;
import web.rulemanage.domain.Products;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.service.ProductsService;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://127.0.0.1:5173",allowCredentials = "true")
public class ProductsController {
    @Resource
    private ProductsService productsService;

    @GetMapping("/Products/find")
    public BaseResponse<Products> findProducts(String productid){
        Products products = productsService.findProducts(productid);
        return ResultUtils.success(products);
    }
    @GetMapping("/Products/pageList")
    public BaseResponse<Page<Products>> findAllProducts(long pageSize, long pageNum){
        QueryWrapper<Products> queryWrapper = new QueryWrapper<>();
        Page<Products> productsPage = productsService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return ResultUtils.success(productsPage);
    }
    @PostMapping("/Products/add")
    public BaseResponse<Integer> addProducts(@RequestBody Products pro){
        return ResultUtils.success(productsService.addProducts(pro));
    }
    @PostMapping("/Products/update")
    public BaseResponse<Integer> updateProducts(@RequestBody Products pro){
        if (pro == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return ResultUtils.success(productsService.updateProducts(pro));
    }
    @DeleteMapping("/Products/delete/{productid}")
    public int deleteProducts(@PathVariable int productid){
        return productsService.deleteProducts(productid);
    }
}
