package com.gl.emwa.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.emwa.repository.EmployeeRepository;
import com.gl.emwa.service.EmployeeDeleteService;

@Service
public class EmployeeDeleteServiceImpl implements EmployeeDeleteService {
	
	@Autowired
	EmployeeRepository deleteRepository;
	
	@Override
	public String deleteEmployeeById(long id) {
		deleteRepository.deleteById(id);
		return "Deleted employee id - " + id;
	}

}
