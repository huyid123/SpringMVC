package com.giahuy.webapp.dao.impl;
import com.giahuy.webapp.dao.IProductDAO;
import com.giahuy.webapp.mapper.ProductMapper;
import com.giahuy.webapp.model.ProductModel;


import java.sql.*;
import java.util.List;

public class ProductDAO extends AbstractDAO<ProductModel> implements IProductDAO {

    @Override
    public List<ProductModel> findByCategoryId(Long categoryId) {
        String sql = "select * from product where categoryid = ?";
        return query(sql, new ProductMapper(), categoryId);
    }

    @Override
    public Long save(ProductModel productModel) {
            StringBuilder sql = new StringBuilder("insert into product (product_name, categoryid, price, description");
            sql.append("createddate = ?, createdby = ?)");
            sql.append(" values(?, ?, ?, ?, ?, ?)");
            return insert(sql.toString(), productModel.getProductName(), productModel.getCategoryId(),
                    productModel.getPrice(), productModel.getDescription(),
                    productModel.getCreatedDate(), productModel.getCreatedBy());
    }

    @Override
    public ProductModel findOne(Long id) {
        String sql = "select * from product where id = ?";
        List<ProductModel> product = query(sql, new ProductMapper(), id);
        return product.isEmpty() ? null : product.get(0);
    }

    @Override
    public void delete(Long id) {
        String sql = "delete from product where id = ?";
        update(sql, id);
    }

    @Override
    public List<ProductModel> findALL() {
        String sql = "select * from product";
        return query(sql, new ProductMapper());
    }

    @Override
    public void update(ProductModel updateProduct) {
        StringBuilder sql = new StringBuilder("Update product set product_name= ?, categoryId = ?, price= ?, description= ?,");
        sql.append(" createddate = ?, modifieddate = ?, createdby = ?, modifiedby = ? WHERE id = ?");
        update(sql.toString(), updateProduct.getProductName(), updateProduct.getCategoryId(),
                updateProduct.getPrice(), updateProduct.getDescription(),
                updateProduct.getCreatedDate(), updateProduct.getModifiedDate(),
                updateProduct.getCreatedBy(), updateProduct.getModifiedBy(), updateProduct.getId());
    }

}

 /*   @Override
    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
        return null;
    }*/

