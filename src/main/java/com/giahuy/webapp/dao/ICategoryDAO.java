package com.giahuy.webapp.dao;

import com.giahuy.webapp.model.CategoryModel;

import java.util.List;

public interface ICategoryDAO  {
    List<CategoryModel> findAll();
}
