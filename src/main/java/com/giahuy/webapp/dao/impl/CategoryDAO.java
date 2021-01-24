package com.giahuy.webapp.dao.impl;

import com.giahuy.webapp.dao.ICategoryDAO;
import com.giahuy.webapp.mapper.CategoryMapper;
import com.giahuy.webapp.model.CategoryModel;
import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

    @Override
    public List<CategoryModel> findAll() {
        String sql = "select * from category ";
        return query(sql, new CategoryMapper());
    }
}


