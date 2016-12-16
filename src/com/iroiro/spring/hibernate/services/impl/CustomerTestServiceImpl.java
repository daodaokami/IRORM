package com.iroiro.spring.hibernate.services.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iroiro.spring.hibernate.dao.CustomerManageDao;
import com.iroiro.spring.hibernate.entities.Customer;
import com.iroiro.spring.hibernate.entities.Ordder;
import com.iroiro.spring.hibernate.services.CustomerTestService;

@Service
public class CustomerTestServiceImpl implements CustomerTestService {

	@Autowired
	CustomerManageDao cdm;
	
	@Override
	public void ShowCtmInfo(Integer ctmId) {
		// TODO Auto-generated method stub
		String cInfo = "姓名：" + cdm.findCustomerNameById(ctmId);
		System.out.println(cInfo);
	}

	@Override
	public void showCtmHisShopInfo(Integer ctmid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveNewCtm(String name) {
		// TODO Auto-generated method stub
		cdm.insertCustomer(name);
	}

	@Override
	public void deleteOldCtm(Integer ctmId) {
		// TODO Auto-generated method stub
		cdm.deleteCustomerById(ctmId);
	}

	@Override
	public void dishShopService(Integer resId, Integer empId, Integer ctmId, Date date , Integer table) {
		// TODO Auto-generated method stub
		cdm.dishShopDao(resId, empId, ctmId, date, table);
	}

	@Override
	public Customer returnCustomer(Integer ctmId) {
		// TODO Auto-generated method stub
		Customer ctm = cdm.returnCusotmer(ctmId);
		List<Ordder> ordders = cdm.returnOrders(ctmId);
		Set<Ordder> os = new HashSet<Ordder>();
		for(int i=0;i<ordders.size();i++){
			os.add(ordders.get(i));
		}
		ctm.setOrders(os);
		return ctm;
	}

	@Override
	public List<Customer> returnCustomers(Integer resId) {
		// TODO Auto-generated method stub
		return cdm.returnCusotmers(resId);
	}

}
