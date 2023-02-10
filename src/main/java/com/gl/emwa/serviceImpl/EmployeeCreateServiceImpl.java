package com.gl.emwa.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.emwa.entity.Employee;
import com.gl.emwa.repository.EmployeeRepository;
import com.gl.emwa.service.EmployeeCreateService;

@Service
public class EmployeeCreateServiceImpl implements EmployeeCreateService {
	
	@Autowired
	EmployeeRepository createRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		return createRepository.saveAndFlush(employee);	
	}

	

}
