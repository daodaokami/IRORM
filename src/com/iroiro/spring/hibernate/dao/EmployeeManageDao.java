package com.iroiro.spring.hibernate.dao;

import java.util.List;

import com.iroiro.spring.hibernate.entities.Employee;

public interface EmployeeManageDao {
	//查找
	public String findEmployeeNameById(int empId);
	public String findEmployeeTeleById(int empId);
	public int findEmployeePosition(int empId);
	public int findEmployeeSalaryById(int empId);
	public int findEmployeeLeaderById(int empId);
	public int findRestaurantIdByempId(int empId);
	
	public List<Object[]> findAllEmp();
	//插入
	public void insertEmployee(String name,String tele, Integer resId);//这里就初始化一个员工
	public void insertEmployee(String name,String tele,int salary , Integer resId);
		
	//删除
	public void deleteEmployeeById(int empId);
		
	//更新
	public void updateEmployeeSalary(int empId,int newSalary);
	public void updateEmployeePosition(int empId,int newPosition);
	public void updateEmployeeLeader(int empId,int leaderId);
	
	public Employee returnEmp(Integer empId);
	public List<Employee> returnEmps(Integer resId);
	public List<Employee> returnEmps();
}
