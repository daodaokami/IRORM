package com.iroiro.spring.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.Order;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iroiro.spring.hibernate.dao.OrderManageDao;
import com.iroiro.spring.hibernate.entities.Customer;
import com.iroiro.spring.hibernate.entities.Dish;
import com.iroiro.spring.hibernate.entities.Employee;
import com.iroiro.spring.hibernate.entities.Material;
import com.iroiro.spring.hibernate.entities.Ordder;
import com.iroiro.spring.hibernate.entities.Restaurant;

@Repository
public class OrderManageDaoImpl implements OrderManageDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
		//获取和当前线程绑定的session,然后就可以在下面实现一个个的方法了
	}

	
	@Override
	public Date findOrderDateById(int orderId) {
		// TODO Auto-generated method stub
		String hql = "select o.date from Order o where o.odId = ?";
		Query query = getSession().createQuery(hql).setInteger(0, orderId);
		return (Date)query.uniqueResult();
	}

	@Override
	public int findOrderTableById(int orderId) {
		// TODO Auto-generated method stub
		String hql = "select o.table from Order o where o.odId = ?";
		Query query = getSession().createQuery(hql).setInteger(0, orderId);
		return (int)query.uniqueResult();	}

	@Override
	public int findResofOrder(int orderId) {
		// TODO Auto-generated method stub
		String hql = "select o.restaurant.resId from Order o where o.odId = ?";
		Query query = getSession().createQuery(hql).setInteger(0, orderId);
		return (int)query.uniqueResult();
	}

	@Override
	public int findCustomerofOrder(int orderId) {
		// TODO Auto-generated method stub
		String hql = "select o.customer.ctmId from Order o where o.odId = ?";
		Query query = getSession().createQuery(hql).setInteger(0, orderId);
		return (int)query.uniqueResult();	}

	@Override
	public int findEmpofOrder(int orderId){
		String hql = "select o.employee.empId from Order o where o.odId = ?";
		Query query = getSession().createQuery(hql).setInteger(0, orderId);
		return (int)query.uniqueResult();
	}
	
	@Override
	public int findOrderPrice(int orderId) {
		// //这里牵扯有关联的dish集合
		Ordder order = (Ordder) getSession().get(Ordder.class, orderId);
		Set<Dish> dishes = order.getDishes();
		int price = 0;
		for(Iterator<Dish> iternator = dishes.iterator();iternator.hasNext();){
			price += iternator.next().getDhPrice();
		}
		return price;
	}


	@Override
	public void deleteOrderById(int orderId) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void deleteOrderItemsById(int orderId, List<Integer> dishId){
		
	}

	@Override
	public void updateOrderPrice(int orderId, int newPrice) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateOrderPrice8(int orderId, int newPrice) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateOrderPrice9(int orderId, int newPrice) {
		// TODO Auto-generated method stub

	}


	@Override
	public List<Object[]> findAllOrder() {
		// TODO Auto-generated method stub
		String hql = "select o.odId,o.date,o.table from Order o";
		Query query = getSession().createQuery(hql);
		List<Object[]> objs = query.list();
		for(Object[] obj:objs){
			System.out.println(Arrays.asList(obj));
		}
		return objs;
	}


	@Override
	public List<Object[]> findAllOrderGroupByRes(Integer resId) {
		// TODO Auto-generated method stub
		String hql = "select o.odId,o.date,o.table from Order o where o.restaurant.resId = ?";
		Query query = getSession().createQuery(hql).setInteger(0, resId);
		List<Object[]> objs = query.list();
		for(Object[] obj:objs){
			System.out.println(Arrays.asList(obj));
		}
		return objs;
		
	}


	@Override
	public Ordder returnOrder(Integer orderId) {
		// TODO Auto-generated method stub
		try{
			String hql = "select new Ordder(o.orderId,o.date,o.ctmTable) "
				+ "from Ordder o where o.orderId = ?"; 
			Query query = getSession().createQuery(hql).setInteger(0, orderId);
			Ordder ordder = (Ordder) query.uniqueResult(); 
			return ordder;
		}catch(Exception e){
			return null;
		}
	}


	@Override
	public List<Ordder> returnOrders(Integer resId) {
		// TODO Auto-generated method stub
		try{
			String hql = "select new Ordder(o.orderId,o.date,o.ctmTable) "
				+ "from Ordder o where o.restaurant.resId = ?"; 
			Query query = getSession().createQuery(hql).setInteger(0, resId);
			List<Ordder> ordders = new ArrayList<Ordder>(); 
			ordders = query.list();
			return ordders;
		}catch(Exception e){
			return null;
		}
	}


	@Override
	public List<Ordder> returnOrders() {
		// TODO Auto-generated method stub
		try{
			String hql = "select new Ordder(o.orderId,o.date,o.ctmTable) "
				+ "from Ordder o"; 
			Query query = getSession().createQuery(hql);
			List<Ordder> ordders = new ArrayList<Ordder>();
			ordders = query.list();
			return ordders;
		}catch(Exception e){
			return null;
		}
	}
	
	@Override
	public List<Dish> returnDishes(Integer orderId){
		Ordder order = (Ordder) getSession().get(Ordder.class, orderId);
		List<Dish> dhes = new ArrayList<Dish>();
		Set<Dish> dishes = order.getDishes();
		System.out.println("dishes.size():"+dishes.size());
		for(Iterator<Dish> iternator = dishes.iterator();iternator.hasNext();){
			Dish dht = new Dish();
			dht = iternator.next();
			Dish dh = new Dish();
			dh.setDhId(dht.getDhId());
			dh.setDhName(dht.getDhName());
			dh.setDhPrice(dht.getDhPrice());
			dhes.add(dh);
		}
		System.out.println("dhessize():"+dhes.size());
		return dhes;
	}


	@Override
	public Customer returnCustomer(Integer orderId) {
		// TODO Auto-generated method stub
		try{
			Ordder order = (Ordder) getSession().get(Ordder.class, orderId);
			Customer ctm = new Customer();
			ctm.setCtmId(order.getCustomer().getCtmId());
			ctm.setCtmName(order.getCustomer().getCtmName());
			return ctm;
		}
		catch(Exception e){
			return null;
		}
	}


	@Override
	public void saveOrder(Ordder ordder) {
		// TODO Auto-generated method stub
		getSession().save(ordder);
	}

}
