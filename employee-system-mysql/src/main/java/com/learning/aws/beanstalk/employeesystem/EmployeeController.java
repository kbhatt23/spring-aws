package com.learning.aws.beanstalk.employeesystem;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	private final static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeRepository repository;

	@GetMapping
	public List<Employee> findAllEmployees() {
		logger.info("findAllEmployees:called to fetch all employees");
		List<Employee> employees = repository.findAll();
		if (employees == null || employees.isEmpty()) {
			logger.error("findAllEmployees:No employee exist in DB");
			throw new RuntimeException("No employee exist in DB");
		}
		logger.info("findAllEmployees:Employees found " + employees);
		return employees;
	}

	@GetMapping("/{id}")
	public Employee findEmployeeById(@PathVariable int id) {
		logger.info("findEmployeeById:called to fetch employee with id " + id);
		Employee employee = repository.findById(id).orElseThrow(() -> new RuntimeException("No employee exist in DB with ID "+id));
		logger.info("findEmployeeById:employee found " + employee);
		return employee;
	}

	@PostMapping
	public ResponseEntity<Integer> createEmployee(@RequestBody Employee employee) {
		logger.info("createEmployee:called to create employee " + employee);
		if (employee.getId() != null) {
			logger.error("createEmployee:ID must be empty while creating employee" + employee);
			throw new RuntimeException("ID must be empty while creating employee");
		}
		repository.save(employee);
		logger.info("createEmployee:Employee created " + employee);
		return new ResponseEntity<Integer>(employee.getId(), HttpStatus.CREATED);
	}

	@PutMapping
	public Employee updateEmployee(@RequestBody Employee employee) {
		logger.info("updateEmployee:called to update employee " + employee);
		if (employee.getId() == null) {
			logger.error("updateEmployee:ID must not be empty for " + employee);
			throw new RuntimeException("ID must not be empty while updating employee");
		}
		logger.info("updateEmployee:employee updated " + employee);
		return repository.save(employee);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
		logger.info("deleteEmployee:called to delete employee " + id);
		repository.deleteById(id);
		logger.info("deleteEmployee:employee deleted with id " + id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
