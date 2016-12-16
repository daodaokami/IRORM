package com.iroiro.spring.hibernate.services;

import java.util.List;

import com.iroiro.spring.hibernate.entities.Ordder;

public interface OrderTestService {
	public void showOrderInfo(Integer orderId);
	public void	showAllOrder();
	public void showOrderPrice(Integer orderId);
	
	public int returnOrderPrice(Integer orderId);
	public Ordder returnOrder(Integer orderId);
	public List<Ordder> returnOrders(Integer resId);
	public List<Ordder> returnOrders();
	
	public void saveOrdder(Ordder ordder);
}
