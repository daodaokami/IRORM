package com.iroiro.spring.hibernate.entities;

import java.util.HashSet;
import java.util.Set;

public class Employee {
	private Integer empId;
	private String empName;
	private String empTele;
	private Integer empPosition;//0-boss,1-仓库管理员,2-服务员,3-收银员
	private Integer empSalary;
	private Integer leaderId;
	
	private Restaurant restaurant;
	private Set<Ordder> Ordders = new HashSet<Ordder>();

	
	public Set<Ordder> getOrdders() {
		return Ordders;
	}

	public void setOrdders(Set<Ordder> ordders) {
		Ordders = ordders;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpTele() {
		return empTele;
	}

	public void setEmpTele(String empTele) {
		this.empTele = empTele;
	}

	public Integer getEmpPosition() {
		return empPosition;
	}

	public void setEmpPosition(Integer empPosition) {
		this.empPosition = empPosition;
	}

	public Integer getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(Integer empSalary) {
		this.empSalary = empSalary;
	}

	public Integer getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(Integer leaderId) {
		this.leaderId = leaderId;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Employee(String empName, String empTele, Integer empPosition, Integer empSalary, Integer leaderId) {
		super();
		this.empName = empName;
		this.empTele = empTele;
		this.empPosition = empPosition;
		this.empSalary = empSalary;
		this.leaderId = leaderId;
	}

	public Employee() {
		super();
	}
	
	
	public Employee(Integer empId, String empName, String empTele, Integer empPosition, Integer empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empTele = empTele;
		this.empPosition = empPosition;
		this.empSalary = empSalary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empTele=" + empTele + ", empPosition="
				+ empPosition + ", empSalary=" + empSalary + ", leaderId=" + leaderId + ", restaurant=" + restaurant
				+ ", Ordders=" + Ordders + "]";
	}
	
	
}
