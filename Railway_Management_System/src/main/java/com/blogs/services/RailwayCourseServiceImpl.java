package com.blogs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.entity.Category;
import com.blogs.entity.RailwayCourse;
import com.blogs.repository.RailwayCourseRepository;


@Service
@Transactional
public class RailwayCourseServiceImpl implements RailwayCourseService{

	@Autowired
	private RailwayCourseRepository railwayCourseRepository;
	
	@Override
	public RailwayCourse addNewCourse(RailwayCourse course) {
		
		return railwayCourseRepository.save(course);
	}

	@Override
	public List<RailwayCourse> getAllcourses() {
		
		return railwayCourseRepository.findAll();
	}

	@Override
	public void deleteRailway(Long id) {
		
		railwayCourseRepository.deleteById(id);
	}

	@Override
	public List<RailwayCourse> Getbycategory(Category category) {
		

		return railwayCourseRepository.findAllByCategory(category);
	}

	@Override
	public void updateRailCourse(RailwayCourse r) {
		Optional<RailwayCourse> op = railwayCourseRepository.findById(r.getId());
		if(op.isPresent()) {
			RailwayCourse r2 = op.get();
			r2.setName(r.getName());
			r2.setCategory(r.getCategory());
			r2.setStartDate(r.getStartDate());
			r2.setEndDate(r.getEndDate());
			r2.setSource(r.getSource());
			r2.setDestination(r.getDestination());
			r2.setStationCode(r.getStationCode());
			r2.setDistance(r.getDistance());
			r2.setFrequency(r.getFrequency());
			railwayCourseRepository.save(r);
		}
	}
	
	

}
