package com.iroiro.spring.hibernate.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.iroiro.spring.hibernate.entities.Customer;
import com.iroiro.spring.hibernate.entities.Dish;
import com.iroiro.spring.hibernate.entities.Ordder;

public interface OrderManageDao {
	//查找
	public Date findOrderDateById(int orderId);
	public int findOrderTableById(int orderId);
	public int findResofOrder(int orderId);
	public int findEmpofOrder(int orderId);
	public int findCustomerofOrder(int orderId);
	public int findOrderPrice(int orderId);
				
	public List<Object[]> findAllOrder();
	public List<Object[]> findAllOrderGroupByRes(Integer resId);
	//插入,一个人的order可以包含多个菜，待定，这里先不实现，因为
	//应该是在点菜的活动中添加订单的，不在order的管理范围之内，这
	
	//删除
	public void deleteOrderById(int orderId);
	public void deleteOrderItemsById(int orderId, List<Integer> dishId);
				
	//更新
	public void updateOrderPrice(int orderId,int newPrice);
	public void updateOrderPrice8(int orderId,int newPrice);//表示打8折
	public void updateOrderPrice9(int orderId,int newPrice);//表示打9折
	
	public Ordder returnOrder(Integer orderId);
	public List<Ordder> returnOrders(Integer resId);
	public List<Ordder> returnOrders();
	
	public List<Dish> returnDishes(Integer orderId);
	public Customer returnCustomer(Integer orderId);
	
	public void saveOrder(Ordder ordder);

}
