package com.iroiro.spring.hibernate.services;

import java.util.List;

import com.iroiro.spring.hibernate.entities.Employee;

public interface EmployeeTestService {
	public void showEmpInfo(Integer empId);
	public void addEmpToRes(String name,String tele,Integer resId);
	public void deleteOldEmp(Integer empId);
	
	public void updateEmpSalary(Integer empId,int newSalary);
	public void updateEmpPosiandLeader(Integer empId,int newPosition,int newLeader);
	
	public Employee returnEmp(Integer empId);
	public List<Employee> returnEmps(Integer resId);
	public List<Employee> returnEmps();
}
