package com.iroiro.spring.hibernate.services.impl;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iroiro.spring.hibernate.dao.OrderManageDao;
import com.iroiro.spring.hibernate.entities.Customer;
import com.iroiro.spring.hibernate.entities.Dish;
import com.iroiro.spring.hibernate.entities.Ordder;
import com.iroiro.spring.hibernate.services.OrderTestService;

@Service
public class OrderTestServiceImpl implements OrderTestService {

	@Autowired
	OrderManageDao omd; 
	
	@Override
	public void showOrderInfo(Integer orderId) {
		// TODO Auto-generated method stub
		String odInfo = "[OrderDate:" + omd.findOrderDateById(orderId);
		odInfo += ", OrderTable:" + omd.findOrderTableById(orderId);
		odInfo += ", OrderPrice：" + omd.findOrderPrice(orderId);
		System.out.println(odInfo);
	}
	@Override
	public void	showAllOrder(){
		omd.findAllOrder();
	}
	
	@Override
	public void showOrderPrice(Integer orderId) {
		// TODO Auto-generated method stub
		int price = omd.findOrderPrice(orderId);
		System.out.println("order总价："+price);
	}
	
	@Override
	public int returnOrderPrice(Integer orderId) {
		// TODO Auto-generated method stub
		int price = omd.findOrderPrice(orderId);
		return price;
	}
	
	@Override
	public Ordder returnOrder(Integer orderId) {
		// TODO Auto-generated method stub
		Ordder ordder = omd.returnOrder(orderId);
		Customer ctm = omd.returnCustomer(orderId);
		List<Dish> dhes = new ArrayList<Dish>();
		Set<Dish> dishes = new HashSet<Dish>();
		dhes = omd.returnDishes(orderId);
		ordder.setCustomer(ctm);
		for(int i=0;i<dhes.size();i++){
			dishes.add(dhes.get(i));
		}
		System.out.println(dishes.size());
		ordder.setDishes(dishes);
		return ordder;
	}
	@Override
	public List<Ordder> returnOrders(Integer resId) {
		// TODO Auto-generated method stub
		List<Ordder> ordders = omd.returnOrders(resId);
		for(int i=0;i<ordders.size();i++){
			//首先设置客人
			ordders.get(i).setCustomer(omd.returnCustomer(ordders.get(i).getOrderId()));
			//然后设置所点的菜
			List<Dish> dhes = new ArrayList<Dish>();
			Set<Dish> dishes = new HashSet<Dish>();
			dhes = omd.returnDishes(ordders.get(i).getOrderId());
			for(int j=0;j<dhes.size();j++){
				dishes.add(dhes.get(j));
			}
			ordders.get(i).setDishes(dishes);
		}
		return ordders;
	}
	@Override
	public List<Ordder> returnOrders() {
		// TODO Auto-generated method stub
		List<Ordder> ordders = omd.returnOrders();
		for(int i=0;i<ordders.size();i++){
			//首先设置客人
			ordders.get(i).setCustomer(omd.returnCustomer(ordders.get(i).getOrderId()));
			//然后设置所点的菜
			List<Dish> dhes = new ArrayList<Dish>();
			Set<Dish> dishes = new HashSet<Dish>();
			dhes = omd.returnDishes(ordders.get(i).getOrderId());
			for(int j=0;j<dhes.size();j++){
				dishes.add(dhes.get(j));
			}
			ordders.get(i).setDishes(dishes);
		}
		return ordders;
	}
	@Override
	public void saveOrdder(Ordder ordder) {
		// TODO Auto-generated method stub
		omd.saveOrder(ordder);
	}



}
