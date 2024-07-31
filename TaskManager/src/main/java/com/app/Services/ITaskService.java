package com.app.Services;

import java.util.List;
import java.util.Optional;

import com.app.Entities.Task;
import com.app.customexeption.CustomException;
import com.app.dto.CreateDTO;

public interface ITaskService {
	Task AddTask(Task t) throws CustomException;
	
	List<CreateDTO> GetDetails();
	
	Optional<Task> DeleteById(Long id);
	
	String UpdateTask(Task t);
	
	List<Task> FetchDetails(String city);
	
	String UpdateParticularFeilds(Task t);

}
