package com.gl.emwa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.emwa.service.EmployeeDeleteService;

@RestController
@RequestMapping("/api")
public class EmployeeDeleteController {
	
	@Autowired
	EmployeeDeleteService deleteService;
	
	@GetMapping("/employees/")
	public String deleteEmployeeById(long id) {
		return deleteService.deleteEmployeeById(id);
	}

}
