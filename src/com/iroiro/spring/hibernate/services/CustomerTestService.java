package com.iroiro.spring.hibernate.services;

import java.util.Date;
import java.util.List;

import com.iroiro.spring.hibernate.entities.Customer;

public interface CustomerTestService {
	public void ShowCtmInfo(Integer ctmId);
	public void showCtmHisShopInfo(Integer ctmid);//未实现
	public void saveNewCtm(String name);
	public void deleteOldCtm(Integer ctmId);
	public void dishShopService(Integer resId, Integer empId, Integer ctmId, Date date,Integer table);
	
	public Customer returnCustomer(Integer ctmId);
	public List<Customer> returnCustomers(Integer resId);
}
