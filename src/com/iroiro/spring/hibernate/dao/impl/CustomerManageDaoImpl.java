package com.iroiro.spring.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iroiro.spring.hibernate.dao.CustomerManageDao;
import com.iroiro.spring.hibernate.entities.Customer;
import com.iroiro.spring.hibernate.entities.Dish;
import com.iroiro.spring.hibernate.entities.Employee;
import com.iroiro.spring.hibernate.entities.Ordder;
import com.iroiro.spring.hibernate.entities.Restaurant;

/*
 * 
 * 创新的功能点，customer的管理，这里没有实现
 * 
 * */



@Repository
public class CustomerManageDaoImpl implements CustomerManageDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
		//获取和当前线程绑定的session,然后就可以在下面实现一个个的方法了
	}
	
	@Override
	public String findCustomerNameById(int ctmId) {
		// TODO Auto-generated method stub
		String hql = "select c.ctmName from Customer c where c.ctmId = ?";
		Query query = getSession().createQuery(hql).setInteger(0, ctmId);
		return (String)query.uniqueResult();
		
	}


	@Override
	public int findRestaurantIdByCTMId(int ctmId) {
		// TODO Auto-generated method stub
		String hql = "select o.resId from Customer c,Order o where c.ctmId = ? and c.ctmId = o.ctmId";
		//这里返回一个集合，这个方法不现实，不实现
		//这里的思想是customer是我们iroiro的customer，去多哪些餐馆，定过什么样的订单
		return 0;
	}

	@Override
	public void insertCustomer( String name) {
		// TODO Auto-generated method stub
		Customer ctm = new Customer(name);
		getSession().save(ctm);
	}

	@Override
	public void deleteCustomerById(int ctmId) {
		// TODO Auto-generated method stub
		Customer ctm = (Customer) getSession().get(Customer.class, ctmId);
		getSession().delete(ctm);
	}

	@Override
	public void dishShopDao(Integer resId, Integer empId,Integer ctmId, Date date, Integer table) {
		// TODO Auto-generated method stub
		Ordder order = new Ordder(date,table);
		Restaurant res = (Restaurant)getSession().get(Restaurant.class, resId);
		Employee emp = (Employee)getSession().get(Employee.class,empId);
		Customer ctm = (Customer) getSession().get(Customer.class, ctmId);
		order.setRestaurant(res);
		order.setCustomer(ctm);
		order.setEmployee(emp);
		
		getSession().save(order);
	}

	@Override
	public Customer returnCusotmer(Integer ctmId) {
		// TODO Auto-generated method stub
		try{
			String hql = "select new Customer(c.ctmId,c.ctmName)"
					+ " from Customer c where c.ctmId = ?"; 
			Query query = getSession().createQuery(hql).setInteger(0, ctmId);
			Customer ctm = (Customer) query.uniqueResult();
			return ctm;
		}catch(Exception e){
			Customer ctm = null;
			return ctm;
		}
	}

	@Override
	public List<Customer> returnCusotmers(Integer resId) {
		// TODO Auto-generated method stub
		try{//要找到某一个餐馆里面进去的顾客订单，需要n步
			/* 0.需要遍历的是所有订单，麻烦啊
			 * 1.从customer的order中获取resId,判定是否是该餐馆的
			 * 2.插入新建的set中
			 * */
			String hql = "select new Customer(c.ctmId,c.ctmName)"
					+ " from Customer c"; 
			Query query = getSession().createQuery(hql);
			//这里先返回了所有的customer属性
			List<Customer> ctms = new ArrayList<Customer>();
			ctms = query.list();
			for(int i=0;i<ctms.size();i++){
				List<Ordder> os = returnOrders(ctms.get(i).getCtmId());
				Set<Ordder> oss = new HashSet<Ordder>();
				for(int j=0;j<os.size();j++){
					oss.add(os.get(j));
				}
				ctms.get(i).setOrders(oss);
			}
			return ctms;
		}catch(Exception e){
			List<Customer> ctms = null;
			return ctms;
		}
	}

	@Override
	public List<Customer> returnCusotmers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ordder> returnOrders(Integer ctmId) {
		// TODO Auto-generated method stub
		Customer ctm = (Customer)getSession().get(Customer.class, ctmId);
		List<Ordder> ordders = new ArrayList<Ordder>();
		Set<Ordder> os = ctm.getOrders();
		for(Iterator<Ordder> iternator = os.iterator();iternator.hasNext();){
			Ordder ot = new Ordder();
			ot = iternator.next();
			//无法找到restaurant？？？
			Ordder o = new Ordder();
			o.setOrderId(ot.getOrderId());
			ordders.add(o);
		}
		return ordders;
	}


}
