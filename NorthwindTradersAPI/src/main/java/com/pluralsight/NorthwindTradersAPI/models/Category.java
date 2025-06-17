package com.pluralsight.NorthwindTradersAPI.models;

import java.io.Serializable;

public class Category implements Serializable {
    private int categoryId;
    private String categoryName;

    public Category(){
        //do nothing
    }

    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Category{");
        sb.append("categoryId=").append(categoryId);
        sb.append(", categoryName='").append(categoryName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
