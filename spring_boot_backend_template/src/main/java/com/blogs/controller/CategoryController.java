package com.blogs.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.Service.CategoryService;
import com.blogs.dto.ApiResponse;
import com.blogs.entities.Category;

@RestController //=>@Controller at class level +@ResponseBody implicitly added on returns type of
//of request handling methods(@RequestMapping|@GetMapping|@PostMapping..)
@RequestMapping("/categories") //Optional but recommended
public class CategoryController {
	
	@Autowired //byType
	private CategoryService categoryService;

	public CategoryController()
	{
		System.out.println("In constructor of "+getClass());
	}
	/*
	 * 1. Get All Categories
       =>Design end point of REST API
       URL-->http://host:port/categories
       Method-->GET
       Payload(request data)-->None
       Response--> @ResponseBody List<Category>
	 */
	@GetMapping
	public List<Category> listAllCategory()
	{
		System.out.println("In list all categories");
		return categoryService.getAllCategory();  //Controller is calling service layer method
	}
	/*
	 * Design end point of REST API for adding new category(Create)
URL-->http://host:port/categories
Method-->POST
Payload(request data)-->category details (Name and Description): Category entity
Response--> @ResponseBody -- Category (with generated id)
      JSON-->JAVA (de-serialized|Un marshalling)
	 */
	@PostMapping
	public Category addNewCategory(@RequestBody Category category)
	{
		System.out.println("In add new Category "+category);
		return categoryService.addNewCategory(category);
	}
	
	/*
	 * Design end point of REST API for deleting category
       URL-->http://host:port/categories/{categoryId} (URI template variable |Path Variable)
       Method-->DELETE
       Payload(request data)--NONE
       Response--> @ResponseBody --PLain String message
	 */
	@DeleteMapping("/{categoryId}")
	//@PathVariable -->It is method arg level annotation ,
	//to bind incoming path Variable to method arg
	public ApiResponse deleteCategoryDetails(@PathVariable Long categoryId)
	{
		System.out.println("In delete category "+categoryId);
		return new ApiResponse(categoryService.deleteCategory(categoryId));

	}
	/*
	 * Design end point of REST API for getting existing category
       URL-->http://host:port/categories/{categoryId}
       Method-->GET
       Payload(request data)--NONE
       Response--> @ResponseBody --Category
	 */
	@GetMapping("/{catId}")
	public Category getCategoryDetails(@PathVariable Long catId)
	{
		System.out.println("In get Category Details by id "+catId);
		return categoryService.getCategoryDetails(catId);
	}
	/*
	 * Design end point of REST API for updating existing category
URL-->http://host:port/categories
Method-->PUT
Payload(request data)--Category
Response--> @ResponseBody --Category
	 */
	@PutMapping
	public Category updateCategoryDetails(@RequestBody Category category)
	{
		System.out.println("In update Category Details "+category);
		return categoryService.updateCategoryDetails(category);
	}
}
