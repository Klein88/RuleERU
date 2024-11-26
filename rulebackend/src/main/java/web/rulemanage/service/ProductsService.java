package web.rulemanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;
import web.rulemanage.domain.Products;

/**
* @author xpc
* @description 针对表【Products】的数据库操作Service
* @createDate 2023-10-11 14:00:32
*/
public interface ProductsService extends IService<Products> {
    @Transactional
    public int addProducts(Products products);
    @Transactional
    Products findProducts(String ProductID);
    @Transactional
    int updateProducts(Products products);
    @Transactional
    public int deleteProducts(int ProductID);
}
