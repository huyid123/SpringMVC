package com.giahuy.webapp.dao;

import com.giahuy.webapp.model.ProductModel;

import java.util.List;

public interface IProductDAO extends GenericDAO<ProductModel> {
    ProductModel findOne(Long id);
    void delete(Long id);
    List<ProductModel> findALL();
    List<ProductModel> findByCategoryId(Long categoryId);
    Long save(ProductModel productModel);
    void update(ProductModel updateProduct);
}
