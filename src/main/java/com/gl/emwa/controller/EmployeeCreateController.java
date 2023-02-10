package com.gl.emwa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.emwa.entity.Employee;
import com.gl.emwa.service.EmployeeCreateService;

@RestController
@RequestMapping("/api")
public class EmployeeCreateController {
	
	@Autowired
	EmployeeCreateService createService;
	
	@GetMapping("/addEmployee")
	public Employee addEmployee(Employee employee) {
		return createService.addEmployee(employee);
	}

}
