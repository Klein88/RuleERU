package web.rulemanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import web.rulemanage.common.ErrorCode;
import web.rulemanage.domain.Products;
import web.rulemanage.exception.BusinessException;
import web.rulemanage.mapper.ProductsMapper;
import web.rulemanage.service.ProductsService;

/**
* @author xpc
* @description 针对表【Products】的数据库操作Service实现
* @createDate 2023-10-11 14:00:32
*/
@Service
public class ProductsServiceImpl extends ServiceImpl<ProductsMapper, Products>
    implements ProductsService{
    @Resource
    private ProductsMapper productsMapper;

    @Override
    public int addProducts(Products products) {
        if (products == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return productsMapper.insert(products);
    }

    @Override
    public Products findProducts(String ProductID) {
        QueryWrapper<Products> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(ProductID)) {
            queryWrapper.eq("ProductID", ProductID);
        }
        return productsMapper.selectOne(queryWrapper);
    }

    @Override
    public int updateProducts(Products products) {
        if (products == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return productsMapper.updateById(products);
    }

    @Override
    public int deleteProducts(int ProductID) {
        if (ProductID <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return productsMapper.deleteById(ProductID);
    }
}




