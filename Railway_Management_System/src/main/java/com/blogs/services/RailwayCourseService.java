package com.blogs.services;

import java.util.List;

import com.blogs.entity.Category;
import com.blogs.entity.RailwayCourse;


public interface RailwayCourseService {

	RailwayCourse addNewCourse(RailwayCourse course);
	
	public List<RailwayCourse> getAllcourses();
	
	public void deleteRailway(Long id);
	
	public List<RailwayCourse> Getbycategory(Category category);
	
	void updateRailCourse( RailwayCourse r);
}
