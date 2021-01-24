package com.giahuy.webapp.model;

public class CategoryModel extends AbstractModel<CategoryModel> {
    private String categoryName;
    private String code;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
