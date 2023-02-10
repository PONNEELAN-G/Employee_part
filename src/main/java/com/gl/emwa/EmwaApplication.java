package com.gl.emwa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort.Direction;

import com.gl.emwa.entity.Employee;
import com.gl.emwa.service.EmployeeCreateService;
import com.gl.emwa.service.EmployeeDeleteService;
import com.gl.emwa.service.EmployeeReadService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class EmwaApplication implements CommandLineRunner {
	
	@Autowired
	EmployeeReadService employeeReadServiceImpl;
	
	@Autowired
	EmployeeDeleteService employeeDeleteServiceImpl;
	
	@Autowired
	EmployeeCreateService employeeCreateServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(EmwaApplication.class, args);
		System.out.println("Employee Management Rest Api based Web application");
	}

	@Override
	public void run(String... args) throws Exception {
		
		log.info("Fetch all employees ---> {}", employeeReadServiceImpl.getAllEmployee());
		
		long id = 1l;
		Optional<Employee> optionalEmployee = employeeReadServiceImpl.getAEmployeeById(id);
		if (optionalEmployee.isPresent()) {
			log.info("Fetch Employee by id ---> {}", optionalEmployee.get());
		} else {
			log.info("No matching Employee with this id " + id);
		}
		
	//	log.info("Delete Employee by id ---> {}", employeeDeleteServiceImpl.deleteEmployeeById(id));
		
		String firstName = "Ujjawal";
		log.info("Fetch Employees with this First Name ---> {}", employeeReadServiceImpl.getEmployeesWithThisFirstName(firstName));
		
		log.info("Fetch Employees custom sorted by First Name ---> {}", employeeReadServiceImpl.getEmployeesCustomSortedByFirstName(Direction.DESC));
		
		Employee employee = new Employee();
		log.info("Add employee ---> {}", employeeCreateServiceImpl.addEmployee(employee));
		
	}

}
