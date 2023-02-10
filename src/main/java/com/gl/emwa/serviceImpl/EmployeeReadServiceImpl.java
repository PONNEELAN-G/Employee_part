package com.gl.emwa.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gl.emwa.entity.Employee;
import com.gl.emwa.repository.EmployeeRepository;
import com.gl.emwa.service.EmployeeReadService;

@Service
public class EmployeeReadServiceImpl implements EmployeeReadService  {
	
	@Autowired
	EmployeeRepository readRepository;

	@Override
	public List<Employee> getAllEmployee() {
		return readRepository.findAll();
	}

	@Override
	public Optional<Employee> getAEmployeeById(long id) {
		return readRepository.findById(id);
	}

	@Override
	public List<Employee> getEmployeesWithThisFirstName(String firstName) {
		Employee employeeWithThisFirstName = new Employee();
		employeeWithThisFirstName.setFirstName(firstName);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "lastName", "email");
		Example<Employee> example = Example.of(employeeWithThisFirstName, exampleMatcher);
		return readRepository.findAll(example);
		
	}

	@Override
	public List<Employee> getEmployeesCustomSortedByFirstName(Direction order) {
		return readRepository.findAll(Sort.by(order, "firstName"));
		
	}

}
