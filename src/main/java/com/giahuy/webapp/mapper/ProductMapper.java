package com.giahuy.webapp.mapper;

import com.giahuy.webapp.model.ProductModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<ProductModel>{
    @Override
    public ProductModel mapRow(ResultSet resultSet) {
        ProductModel product = new ProductModel();
        try {
            product.setId(resultSet.getLong("id"));
            product.setProductName(resultSet.getString("product_name"));
            product.setPrice(resultSet.getDouble("price"));
            product.setDescription(resultSet.getString("description"));
            product.setCategoryId(resultSet.getLong("categoryid"));
            product.setCreatedDate(resultSet.getTimestamp("createddate"));
            product.setCreatedBy(resultSet.getString("createdby"));
            if (resultSet.getTimestamp("modifieddate") != null){
                product.setModifiedDate(resultSet.getTimestamp("modifieddate"));
            }
            if (resultSet.getString("modifiedby") != null){
                product.setModifiedBy(resultSet.getString("modifiedby"));
            }
            return product;
        } catch (SQLException e){
            return null;
        }
    }
}
