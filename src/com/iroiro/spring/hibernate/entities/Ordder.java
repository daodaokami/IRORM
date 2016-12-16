package com.iroiro.spring.hibernate.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Ordder {//order功能只实现一个菜的订单功能，为了方便
	private Integer orderId;
	
	private Date date;
	private int ctmTable;
	
	private Restaurant restaurant;
	private Customer customer;
	private Employee employee;
	private Set<Dish> dishes = new HashSet<Dish>();

	//没写price因为一个菜还一份，所以price就是dish.price
	
	public Integer getOrderId() {
		return orderId;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getCtmTable() {
		return ctmTable;
	}
	public void setCtmTable(int ctmTable) {
		this.ctmTable = ctmTable;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Set<Dish> getDishes() {
		return dishes;
	}
	public void setDishes(Set<Dish> dishes) {
		this.dishes = dishes;
	}
	
	
	public Ordder(Integer orderId, Date date, int ctmTable, Customer customer) {
		super();
		this.orderId = orderId;
		this.date = date;
		this.ctmTable = ctmTable;
		this.customer = customer;
	}
	public Ordder(Integer orderId, Date date, int ctmTable) {
		super();
		this.orderId = orderId;
		this.date = date;
		this.ctmTable = ctmTable;
	}
	public Ordder(Date date, int ctmTable) {
		super();
		this.date = date;
		this.ctmTable = ctmTable;
	}
	public Ordder() {
		super();
	}
	
	@Override
	public String toString() {
		return "Ordder [orderId=" + orderId + ", date=" + date + ", ctmTable=" + ctmTable + ", restaurant=" + restaurant
				+ ", customer=" + customer + ", employee=" + employee + ", dishes=" + dishes + "]";
	}
	
}
