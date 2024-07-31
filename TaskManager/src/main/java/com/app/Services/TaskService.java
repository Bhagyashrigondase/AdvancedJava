package com.app.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.Entities.Task;
import com.app.Repositories.TaskRepository;
import com.app.customexeption.CustomException;
import com.app.dto.CreateDTO;
@Service
@Transactional
public class TaskService implements ITaskService {
	@Autowired
	private TaskRepository repo;
	
	@Autowired
	private ModelMapper mapper;
	

	@Override
	public Task AddTask(Task t) throws CustomException {
		ValidateName(t);
		ValidateNo(t);
		ValidateDate(t);
		return repo.save(t);
	}
	
	public void ValidateNo(Task t) throws CustomException
	{
		if(t.getMobno().length()!=10)
		{
			throw new CustomException("No must be correct!!!");
		}
	}
	
	public void ValidateName(Task t) throws CustomException
	{
		if(t.getName()=="")
		{
			throw new CustomException("Name must not be blank!!");
		}
	}
	
	public void ValidateDate(Task t) throws CustomException
	{
		if(t.getDate().isBefore(LocalDate.now()))
		{
			throw new CustomException("Date must be correct!!");
		}
	}
	public void ValidateNamedto(CreateDTO t) throws CustomException
	{
		if(t.getName()=="")
		{
			throw new CustomException("Name must not be blank!!");
		}
	}

	@Override
	public List<CreateDTO> GetDetails() {
		
		return repo.findAll().stream().map(dto->
		mapper.map(dto, CreateDTO.class)).collect(Collectors.toList());
	}

	@Override
	public Optional<Task> DeleteById(Long id) {
		Optional<Task> del=null;
		try {
			del=repo.findById(id);
		}catch(Exception e)
		{
			System.out.println("Id does not exists!!!");
		}
		repo.deleteById(id);;
		return del;
	}

	@Override
	public String UpdateTask(Task t) {
		if(repo.existsById(t.getId()))
		{
			repo.save(t);
			return "Updated successfully!!!";
		}
		else
		{
			return "Invalid Id!!!";
		}
		
	}

	@Override
	public List<Task> FetchDetails(String city) {
		
		return repo.findAllByCity(city);
	}

	@Override
	public String UpdateParticularFeilds(@RequestBody Task t) {
		if(repo.existsById(t.getId()))
		{
			Task t1=repo.findAllById(t.getId());
			t1.setCity(t.getCity());
			t1.setFees(t.getFees());
			t1.setMobno(t.getMobno());
			repo.save(t1);
			return "Updated Successfully!!!";
		}
		return "Failed to Update!!";
		
	}

	

}
