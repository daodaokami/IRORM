package com.iroiro.spring.hibernate.dao.impl;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iroiro.spring.hibernate.dao.EmployeeManageDao;
import com.iroiro.spring.hibernate.entities.Employee;
import com.iroiro.spring.hibernate.entities.Material;
import com.iroiro.spring.hibernate.entities.Restaurant;

@Repository
public class EmployeeManageDaoImpl implements EmployeeManageDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
		//获取和当前线程绑定的session,然后就可以在下面实现一个个的方法了
	}

	@Override
	public String findEmployeeNameById(int empId) {
		// TODO Auto-generated method stub
		String hql = "select e.empName from Employee e where e.empId = ?";
		Query query = getSession().createQuery(hql).setInteger(0, empId);
		return (String)query.uniqueResult();
	}

	@Override
	public String findEmployeeTeleById(int empId) {
		// TODO Auto-generated method stub
		String hql = "select e.empTele from Employee e where e.empId = ?";
		Query query = getSession().createQuery(hql).setInteger(0, empId);
		return (String)query.uniqueResult();
	}

	@Override
	public int findEmployeePosition(int empId) {
		// TODO Auto-generated method stub
		String hql = "select e.empPosition from Employee e where e.empId = ?";
		Query query = getSession().createQuery(hql).setInteger(0, empId);
		return (int)query.uniqueResult();
	}

	@Override
	public int findEmployeeSalaryById(int empId) {
		// TODO Auto-generated method stub
		String hql = "select e.empSalary from Employee e where e.empId = ?";
		Query query = getSession().createQuery(hql).setInteger(0, empId);
		return (int)query.uniqueResult();
	}

	@Override
	public int findEmployeeLeaderById(int empId) {
		// TODO Auto-generated method stub
		String hql = "select e.leaderId from Employee e where e.empId = ?";
		Query query = getSession().createQuery(hql).setInteger(0, empId);
		return (int)query.uniqueResult();
	}

	@Override
	public int findRestaurantIdByempId(int empId) {
		// TODO Auto-generated method stub
		String hql = "select e.restaurant.resId from Employee e where e.empId = ?";
		Query query = getSession().createQuery(hql).setInteger(0, empId);
		return (int)query.uniqueResult();
	}

	@Override
	public void insertEmployee(String name, String tele, Integer resId) {
		// TODO Auto-generated method stub
		Employee emp = new Employee(name,tele,1,0,0);//初始化的时候领导设为0
								//  	职位，工资，领导
		Restaurant res = (Restaurant)getSession().get(Restaurant.class, resId);
		emp.setRestaurant(res);
		res.getEMPs().add(emp);
		
		getSession().save(emp);
	}

	@Override
	public void insertEmployee(String name, String tele, int salary, Integer resId) {
		// TODO Auto-generated method stub
		Employee emp = new Employee(name,tele,1,salary,0);//初始化的时候领导设为0
		//  	职位，工资，领导
		Restaurant res = (Restaurant)getSession().get(Restaurant.class, resId);
		emp.setRestaurant(res);
		res.getEMPs().add(emp);

		getSession().save(emp);
	}

	@Override
	public void deleteEmployeeById(int empId) {
		// TODO Auto-generated method stub
		//这里要考虑的是将emp删除后res是否会出错
		Employee emp = (Employee)getSession().get(Employee.class, empId);
		//是否要在res的emps里面删除emp？
		getSession().delete(emp);
	}

	@Override
	public void updateEmployeeSalary(int empId, int newSalary) {
		// TODO Auto-generated method stub
		String hql = "update Employee e set e.empSalary = ? where e.empId = ?";
		getSession().createQuery(hql).setInteger(0, newSalary).setInteger(1, empId).executeUpdate();
	}

	@Override
	public void updateEmployeePosition(int empId, int newPosition) {
		// TODO Auto-generated method stub
		String hql = "update Employee e set e.empPosition = ? where e.empId = ?";
		getSession().createQuery(hql).setInteger(0, newPosition).setInteger(1, empId).executeUpdate();
	}

	@Override
	public void updateEmployeeLeader(int empId, int leaderId) {
		// TODO Auto-generated method stub
		String hql = "update Employee e set e.leaderId = ? where e.empId = ?";
		getSession().createQuery(hql).setInteger(0, leaderId).setInteger(1, empId).executeUpdate();
	}

	@Override
	public List<Object[]> findAllEmp() {
		// TODO Auto-generated method stub
		String hql = "select e.empId,e.empName,e.empPosition,e.empSalary from Employee e";
		Query query = getSession().createQuery(hql);
		List<Object[]> objs = query.list();
		for(Object[] obj:objs){
			System.out.println(Arrays.asList(obj));
		}
		return objs;
	}

	@Override
	public Employee returnEmp(Integer empId) {
		// TODO Auto-generated method stub
		try{
			String hql = "select new Employee(e.empId,e.empName,e.empTele,e.empPosition,e.empSalary)"
					+ " from Employee e where e.empId = ?"; 
			Query query = getSession().createQuery(hql).setInteger(0, empId);
			Employee emp = (Employee) query.uniqueResult();
			return emp;
		}catch(Exception e){
			Employee emp = null;
			return emp;
		}
	}

	@Override
	public List<Employee> returnEmps(Integer resId) {
		// TODO Auto-generated method stub
		try{
			String hql = "select new Employee(e.empId,e.empName,e.empTele,e.empPosition,e.empSalary)"
				+ " from Employee e where e.restaurant.resId = ?"; 
			Query query = getSession().createQuery(hql).setInteger(0, resId);
			List<Employee> emps = query.list();
			return emps;
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<Employee> returnEmps() {
		// TODO Auto-generated method stub
		try{
			String hql = "select new Employee(e.empId,e.empName,e.empTele,e.empPosition,e.empSalary)"
				+ " from Employee e"; 
			Query query = getSession().createQuery(hql);
			List<Employee> emps = query.list();
			return emps;
		}catch(Exception e){
			return null;
		}
	}
	
	
}
