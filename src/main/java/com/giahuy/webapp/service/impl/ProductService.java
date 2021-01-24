package com.giahuy.webapp.service.impl;

import com.giahuy.webapp.dao.IProductDAO;
import com.giahuy.webapp.model.ProductModel;
import com.giahuy.webapp.service.IProductService;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;

public class ProductService implements IProductService {

    @Inject
    private IProductDAO productDAO;

    @Override
    public List<ProductModel> findByCategoryId(Long categoryId) {
        return productDAO.findByCategoryId(categoryId);
    }

    @Override
    public ProductModel save(ProductModel productModel) {
        productModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        productModel.setCreatedBy("");
        Long productId = productDAO.save(productModel);
        return productDAO.findOne(productId);
    }

    @Override
    public ProductModel update(ProductModel updateProduct) {
        ProductModel oldProduct = productDAO.findOne(updateProduct.getId());
        updateProduct.setProductName(oldProduct.getCreatedBy());
        updateProduct.setCreatedBy(oldProduct.getCreatedBy());
        updateProduct.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        updateProduct.setModifiedBy("");
        productDAO.update(updateProduct);
        return productDAO.findOne(updateProduct.getId());
    }

    @Override
    public void deleteProduct(long[] ids) {
        for (Long id: ids) {
            productDAO.delete(id);
        }
    }

    @Override
    public List<ProductModel> findAll() {
        return productDAO.findALL();
    }


}
