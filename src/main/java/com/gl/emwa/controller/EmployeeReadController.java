package com.gl.emwa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.emwa.entity.Employee;
import com.gl.emwa.service.EmployeeReadService;

@RestController
@RequestMapping("/api")
public class EmployeeReadController {
	
	@Autowired
	EmployeeReadService readService;
	
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee() {
		return readService.getAllEmployee();
	}
	
	@GetMapping("/employees/{id}")
	public Optional<Employee> getAEmployeeById(@PathVariable long id) {
		return readService.getAEmployeeById(id);
	}
	
	@GetMapping("/employees/search/{firstName}")
	public List<Employee> getEmployeesWithThisFirstName(@PathVariable String firstName) {
		return readService.getEmployeesWithThisFirstName(firstName);
	}
	
	@GetMapping("/employees/sort")
	public List<Employee> getEmployeesCustomSortedByFirstName(Direction order) {
		return readService.getEmployeesCustomSortedByFirstName(order);
	}

}
