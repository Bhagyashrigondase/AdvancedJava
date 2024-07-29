package com.blogs.Service;

import java.util.List;

import com.blogs.entities.Category;

public interface CategoryService {
	List<Category> getAllCategory();
	Category addNewCategory(Category newCategory);
	String deleteCategory(Long catId);
	Category getCategoryDetails(Long categoryId);
	Category updateCategoryDetails(Category category);
}
