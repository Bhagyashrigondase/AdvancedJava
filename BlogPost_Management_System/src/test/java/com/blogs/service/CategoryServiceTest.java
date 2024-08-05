package com.blogs.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blogs.dto.CategoryDTO;

@SpringBootTest //Annotation for the Spring boot Test framework to enable all spring beans including -Controller,
//Service and DAO beans
class CategoryServiceTest {
	@Autowired
	private CategoryService categoryService;

	@Test
	void test() {
		assertNotNull(categoryService);
	}
	
	@Test
	void GetAllCategories()
	{
		List<CategoryDTO> list=categoryService.getAllCategories();
		assertEquals(3, list.size());
		//Not a good pattern!! (Should not display any response from test case)
		list.forEach(System.out::println);
	}

}
