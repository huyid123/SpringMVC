package com.giahuy.webapp.service.impl;

import com.giahuy.webapp.dao.ICategoryDAO;
import com.giahuy.webapp.dao.impl.CategoryDAO;
import com.giahuy.webapp.model.CategoryModel;
import com.giahuy.webapp.service.ICategoryService;

import javax.inject.Inject;
import java.util.List;

public class CategoryService implements ICategoryService {
    /*private ICategoryDAO categoryDAO;

    public CategoryService(){
        categoryDAO = new CategoryDAO();
    }*/
    @Inject
    private ICategoryDAO categoryDAO;

    @Override
    public List<CategoryModel> findAll() {
        return categoryDAO.findAll();
    }
}
