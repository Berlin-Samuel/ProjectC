package com.chainsys.application.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.application.model.Employee;
import com.chainsys.application.model.EmployeeDao;

@RestController //automatically act as a servlets
public class Service {

	@RequestMapping("/getEmployee")
	public String getData(@RequestParam(name = "id") String id) {
		int empId = Integer.parseInt(id);
		Employee emp = EmployeeDao.getEmployeeById(empId);
		return emp.getFirst_name() + ", " + emp.getLast_name() + ", " + emp.getJob_id() + ", " + emp.getSalary() + ", "
				+ emp.getHire_date() + ", " + emp.getEmail();
	}
	//	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	@RequestMapping("/getAllEmployee")
	public String getAllEmployee() {
		List<Employee> allEmployees = EmployeeDao.getAllEmployee();
		String result = "";
		Iterator<Employee> empIterator = allEmployees.iterator();
		while (empIterator.hasNext()) {
			Employee emp = empIterator.next();
			result += "<div>"+emp.getEmp_id() + emp.getFirst_name() + emp.getLast_name() + emp.getEmail() + emp.getJob_id()
					+ emp.getSalary()+"<div>";
		}
		return result;
	}
	@RequestMapping(value="/newemployee",method=RequestMethod.POST)
	public int addNewEmployee() {
		return 0;
	}
	@RequestMapping(value="/updateemployee",method=RequestMethod.PUT)
	public int modifyEmployee() {
		return 1;
	}
	@RequestMapping(value="/removeemployee",method=RequestMethod.DELETE)
	public int DeleteEmployee() {
		return 2;
	}
}