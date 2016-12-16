package com.iroiro.spring.hibernate.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iroiro.spring.hibernate.dao.EmployeeManageDao;
import com.iroiro.spring.hibernate.entities.Employee;
import com.iroiro.spring.hibernate.services.EmployeeTestService;

@Service
public class EmployeeTestServiceImpl implements EmployeeTestService{

	@Autowired
	EmployeeManageDao emd;
	
	@Override
	public void showEmpInfo(Integer empId) {
		// TODO Auto-generated method stub
		String empInfo = "姓名："+emd.findEmployeeNameById(empId);
		empInfo += "电话："+emd.findEmployeeTeleById(empId);
		empInfo += "职位："+emd.findEmployeePosition(empId);
		empInfo += "工资："+emd.findEmployeeSalaryById(empId);
		empInfo += "餐馆："+emd.findRestaurantIdByempId(empId);
		System.out.println(empInfo);
	}

	@Override
	public void addEmpToRes(String name, String tele, Integer resId) {
		// TODO Auto-generated method stub
		emd.insertEmployee(name, tele, resId);
		System.out.println("插入新的员工，并且对res的员工对应关系做关联");
	}

	@Override
	public void deleteOldEmp(Integer empId) {
		// TODO Auto-generated method stub
		emd.deleteEmployeeById(empId);
		System.out.println("只删除了emp中的关联的res没删");
	}

	@Override
	public void updateEmpSalary(Integer empId, int newSalary) {
		// TODO Auto-generated method stub
		emd.updateEmployeeSalary(empId, newSalary);
		System.out.println("更新empId的工资");
	}

	@Override
	public void updateEmpPosiandLeader(Integer empId, int newPosition, int newLeader) {
		// TODO Auto-generated method stub
		emd.updateEmployeePosition(empId, newPosition);
		emd.updateEmployeeLeader(empId, newLeader);
	}

	@Override
	public Employee returnEmp(Integer empId) {
		// TODO Auto-generated method stub
		return emd.returnEmp(empId);
	}

	@Override
	public List<Employee> returnEmps(Integer resId) {
		// TODO Auto-generated method stub
		return emd.returnEmps(resId);
	}

	@Override
	public List<Employee> returnEmps() {
		// TODO Auto-generated method stub
		return emd.returnEmps();
	}

}
