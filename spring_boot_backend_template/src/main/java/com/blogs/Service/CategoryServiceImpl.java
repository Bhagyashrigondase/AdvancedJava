package com.blogs.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.custom_exception.ResourceNotFoundException;
import com.blogs.entities.Category;
import com.blogs.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	//Dependency-->Dao Layer interface
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAllCategory()
	{
		return categoryRepository.findAll();
	}

	@Override
	public Category addNewCategory(Category newCategory) {
		//Use the method inherited from CRUDRepository
		//public T save(T entity)
		return categoryRepository.save(newCategory);
	}

	@Override
	public String deleteCategory(Long catId) {
		if(categoryRepository.existsById(catId)) {
		//API of CRUDRepo-->public void deleteById(ID id)
		categoryRepository.deleteById(catId);
		return "Category details deleted!!";
		}
		return "Deleting Category failed!!";
	}

	@Override
	public Category getCategoryDetails(Long categoryId) {
			Optional<Category> optional=categoryRepository.findById(categoryId);
		
		return optional.orElseThrow(()->new ResourceNotFoundException("Invalid Category ID!!!"));
	}

	@Override
	public Category updateCategoryDetails(Category category) {
		
		return categoryRepository.save(category);
	}
}
