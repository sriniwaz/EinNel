package com.niwaz.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service("employeeService")
public class EmployeeServiceImplementation implements EmployeeService {

	
	@Autowired
	private EmployeeDao employeeDao;


	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}


	
	public void saveEmployee(EmployeePojo employeePojo) {
		Employee employee = new Employee();
		employee.setEmployee_name(employeePojo.getEmployee_name());
		employee.setEmployee_id(employeePojo.getEmployee_id());
		employee.setEmployee_salary(employeePojo.getEmployee_salary());
		employee.setEmployee_designation(employeePojo.getEmployee_designation());
		employeeDao.save(employee);
	}
	
	public EmployeePojo findEmployee(int employee_id) {

		Optional<Employee> employee = employeeDao.findById(employee_id);
		EmployeePojo employeePojo = new EmployeePojo();
		employeePojo.setEmployee_name(employee.get().getEmployee_name());
		employeePojo.setEmployee_id(employee.get().getEmployee_id());
		employeePojo.setEmployee_salary(employee.get().getEmployee_salary());
		employeePojo.setEmployee_designation(employee.get().getEmployee_designation());

		return employeePojo;
	}
	
	@Override
	public List<EmployeePojo> listEmployee() {
		List<EmployeePojo> employeePojoList = new ArrayList<EmployeePojo>();
		List<Employee> employeeList = employeeDao.findAll();
		for (int i = 0; i < employeeList.size(); i++) {

			Employee employee = employeeList.get(i);

			EmployeePojo employeePojo = new EmployeePojo();
			employeePojo.setEmployee_name(employee.getEmployee_name());
			employeePojo.setEmployee_id(employee.getEmployee_id());
			employeePojo.setEmployee_salary(employee.getEmployee_salary());
			employeePojo.setEmployee_designation(employee.getEmployee_designation());


			employeePojoList.add(employeePojo);

		}

		return employeePojoList;
	}

	
	@Override
	public void deleteEmployee(int employee_id) {

		employeeDao.deleteById(employee_id);

	}

	public EmployeePojo editEmployee(EmployeePojo employeePojo) {

		Optional<Employee> employee = employeeDao.findById(employeePojo.getEmployee_id());
		System.out.println(employeePojo.getEmployee_id());
		employee.get().setEmployee_name(employeePojo.getEmployee_name());
		employee.get().setEmployee_id(employeePojo.getEmployee_id());
		employee.get().setEmployee_salary(employeePojo.getEmployee_salary());
		employee.get().setEmployee_designation(employeePojo.getEmployee_designation());


		return employeePojo;
	}
}
