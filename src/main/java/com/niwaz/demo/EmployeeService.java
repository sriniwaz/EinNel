package com.niwaz.demo;

import java.util.List;


public interface EmployeeService {

	void saveEmployee(EmployeePojo employeePojo);

	List<EmployeePojo> listEmployee();

	EmployeePojo findEmployee(int employee_id);

	void deleteEmployee(int employee_id);

	EmployeePojo editEmployee(EmployeePojo employeePojo);
}
