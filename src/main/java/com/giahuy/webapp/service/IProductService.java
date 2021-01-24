package com.giahuy.webapp.service;

import com.giahuy.webapp.model.ProductModel;

import java.util.List;

public interface IProductService {
    List<ProductModel> findByCategoryId(Long categoryId);
    ProductModel save(ProductModel productModel);
    ProductModel update(ProductModel updateProduct);
    void deleteProduct(long[] ids);
    List<ProductModel> findAll();
}