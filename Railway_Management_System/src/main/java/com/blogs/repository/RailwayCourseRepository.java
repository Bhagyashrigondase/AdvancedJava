package com.blogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.entity.Category;
import com.blogs.entity.RailwayCourse;

public interface RailwayCourseRepository extends JpaRepository<RailwayCourse, Long> {

	List<RailwayCourse> findAllByCategory(Category category);

}
