package com.gl.emwa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort.Direction;

import com.gl.emwa.entity.Employee;

public interface EmployeeReadService {
	
	List<Employee> getAllEmployee();

	Optional<Employee> getAEmployeeById(long id);
	
	List<Employee> getEmployeesWithThisFirstName(String firstName);
	
	List<Employee> getEmployeesCustomSortedByFirstName(Direction order);

}
