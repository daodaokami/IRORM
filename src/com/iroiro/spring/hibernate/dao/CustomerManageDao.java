package com.iroiro.spring.hibernate.dao;

import java.util.Date;
import java.util.List;

import com.iroiro.spring.hibernate.entities.Customer;
import com.iroiro.spring.hibernate.entities.Ordder;

public interface CustomerManageDao {
	//查找
	public String findCustomerNameById(int ctmId);
	public int findRestaurantIdByCTMId(int ctmId);
	//增加查找相关订单dao
	
	//插入,顾客进入饭店就初始化一个客人，自动增加餐馆信息
	public void insertCustomer(String name);
	public void dishShopDao(Integer resId, Integer empId,Integer ctmId, Date date, Integer table);
	
	//删除
	public void deleteCustomerById(int ctmId);

	public Customer returnCusotmer(Integer ctmId);
	public List<Customer> returnCusotmers(Integer resId);
	public List<Customer> returnCusotmers();
	
	public List<Ordder> returnOrders(Integer ctmId);
	
}
