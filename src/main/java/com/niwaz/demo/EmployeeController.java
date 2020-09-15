package com.niwaz.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}


	@PostMapping(value="/save")
	public void saveEmployee(@RequestBody EmployeePojo employeePojo){
		employeeService.saveEmployee(employeePojo); 
		
	}

	@GetMapping(value = "/list")
	public ResponseEntity<List<EmployeePojo>> listEmployee() {
		return ResponseEntity.ok(employeeService.listEmployee());
	}

	@GetMapping(value = "/get/{id}")
	public ResponseEntity<EmployeePojo> getEmployee(@PathVariable(value = "id") int employee_id) {
		return ResponseEntity.ok(employeeService.findEmployee(employee_id));
	}
	
	@PutMapping(value = "/edit")
	public ResponseEntity<EmployeePojo> updateEmployee(@RequestBody EmployeePojo employeePojo) {

		if (employeeService.findEmployee(employeePojo.getEmployee_id())!=null) {
            ResponseEntity.badRequest().build();
        }

	        return ResponseEntity.ok(employeeService.editEmployee(employeePojo));
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Employee>  deleteEmployee(@PathVariable(value ="id") int employee_id) {
        if (employeeService.findEmployee(employee_id)!=null) {
            ResponseEntity.badRequest().build();
        }

        employeeService.deleteEmployee(employee_id);

        return ResponseEntity.ok().build();
 
	}
}
