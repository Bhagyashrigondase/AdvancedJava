package com.blogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.entity.Category;
import com.blogs.entity.RailwayCourse;
import com.blogs.services.RailwayCourseService;

@RestController
@RequestMapping("/railways")
public class RailwayCourseController {
	
	@Autowired
	private RailwayCourseService courseService;
	
	@PostMapping
	public String addNewRailwayCourse(@RequestBody RailwayCourse course) {
		courseService.addNewCourse(course);
		return "Course Aadded Successfully";
	}
	
	@GetMapping
	public List<RailwayCourse> getAll(){
		
		return courseService.getAllcourses();
	}
	
	
	@DeleteMapping("/id")
	
	public void deleteRailway(Long id) {
		courseService.deleteRailway(id);
	}
	
    @GetMapping("/category/{category}")
    public List<RailwayCourse> getRailwaysByCategory(@PathVariable Category category) {
        return courseService.Getbycategory(category);
    }
    
    @PutMapping("/railways/{id}")
    
    public void updateRailCourse(@RequestBody RailwayCourse r){
    	courseService.updateRailCourse(r);
    	
    }

}
