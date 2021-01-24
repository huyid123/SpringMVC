package com.giahuy.webapp.mapper;

import com.giahuy.webapp.model.CategoryModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<CategoryModel>{

    @Override
    public CategoryModel mapRow(ResultSet resultSet) {
        try {
            CategoryModel category = new CategoryModel();
            category.setId(resultSet.getLong("id"));
            category.setCategoryName(resultSet.getString("Category name:"));
            category.setCode(resultSet.getString("code:"));
            return category;
        } catch (SQLException e){
            return null;
        }
    }
}
