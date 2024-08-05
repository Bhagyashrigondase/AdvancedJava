package com.blogs.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name= "Railway")
public class RailwayCourse {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id ;
	
	@NotBlank
	private String name ;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Category category;
	
	@NotNull
	private  Date startDate;
	
	@NotNull
	private Date endDate ;
	
	@NotBlank
	private String source ;
	
	@NotBlank
	private String destination ;
	
	@NotBlank
	private String stationCode ;
	
	@NotNull
	private double distance;
	
	@NotBlank
	private String frequency;
	
	public RailwayCourse() {
		// TODO Auto-generated constructor stub
	}

	public RailwayCourse(Long id, String name, Category category, Date startDate, Date endDate, String source,
			String destination, String stationCode, double distance, String frequency) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.startDate = startDate;
		this.endDate = endDate;
		this.source = source;
		this.destination = destination;
		this.stationCode = stationCode;
		this.distance = distance;
		this.frequency = frequency;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	

	@Override
	public String toString() {
		return "RailwayCourse [id=" + id + ", name=" + name + ", category=" + category + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", source=" + source + ", destination=" + destination + ", stationCode="
				+ stationCode + ", distance=" + distance + ", frequency=" + frequency + "]";
	}
	
	
	
	
}
