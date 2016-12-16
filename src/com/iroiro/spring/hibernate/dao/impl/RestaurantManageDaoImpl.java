package com.iroiro.spring.hibernate.dao.impl;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iroiro.spring.hibernate.dao.RestaurantManageDao;
import com.iroiro.spring.hibernate.entities.Restaurant;
import com.iroiro.spring.hibernate.entities.Style;

@Repository
public class RestaurantManageDaoImpl implements RestaurantManageDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
		//获取和当前线程绑定的session,然后就可以在下面实现一个个的方法了
	}
	
	@Override
	public String findRestaurantNameById(int resId) {
		// TODO Auto-generated method stub
		String hql = "select r.resName from Restaurant r where r.resId = ?";
		Query query = getSession().createQuery(hql).setInteger(0, resId);
		return (String)query.uniqueResult();
	}

	@Override
	public String findRestaurantAddressById(int resId) {
		// TODO Auto-generated method stub
		String hql = "select r.resAddress from Restaurant r where r.resId = ?";
		Query query = getSession().createQuery(hql).setInteger(0, resId);
		return (String)query.uniqueResult();
	}

	@Override
	public String findRestaurantTeleById(int resId) {
		// TODO Auto-generated method stub
		String hql = "select r.resTele from Restaurant r where r.resId = ?";
		Query query = getSession().createQuery(hql).setInteger(0, resId);
		return (String)query.uniqueResult();
	}

	@Override
	public Style findRestaurantStyleById(int resId) {
		// TODO Auto-generated method stub
		Restaurant res = (Restaurant)getSession().get(Restaurant.class, resId);
		return res.getStyle();
	}

	@Override
	public Integer insertRestaurant(String name, String addr, String tele) {
		// TODO Auto-generated method stub
		Restaurant res = new Restaurant(name,addr,tele);
		Style style = new Style(1,false,false,false);
		res.setStyle(style);
		style.setRestaurant(res);
		String hql = "select new Restaurant(r.resId,r.resName,r.resAddress,r.resTele) "
				+ "from Restaurant r where r.resName = ?";
		Query query = getSession().createQuery(hql).setString(0, name);
		Restaurant resT = (Restaurant)query.uniqueResult();
		System.out.println(resT);
		//System.out.println(resT.getResName()+" , "+name);//是null不能查询
		if(resT != null)
			return 0;//有重复的
		else{
			getSession().save(res);
			getSession().save(style);
			return 1;//插入数据返回1，未插入有重复返回0
		}
	}

	@Override
	public void deleteRestaurantById(int resId) {
		// TODO Auto-generated method stub
		Restaurant res = (Restaurant)getSession().get(Restaurant.class, resId);
		getSession().delete(res);
	}

	@Override
	public void updateRestaurantNameById(int resId, String newResName) {
		// TODO Auto-generated method stub
		Restaurant res = (Restaurant)getSession().get(Restaurant.class, resId);
		res.setResName(newResName);
	}

	@Override
	public void updateRestaurantAddressById(int resId, String newAddress) {
		// TODO Auto-generated method stub
		Restaurant res = (Restaurant)getSession().get(Restaurant.class, resId);
		res.setResAddress(newAddress);
	}

	@Override
	public void updateRestaurantTeleById(int resId, String newTele) {
		// TODO Auto-generated method stub
		Restaurant res = (Restaurant)getSession().get(Restaurant.class, resId);
		res.setResTele(newTele);
	}

	@Override
	public void updateRestaurantStyleById(Integer resId, int newColor, 
			boolean ifhasTime, boolean ifhasOrderManager,
			boolean ifhasSpecial) {
		// TODO Auto-generated method stub
		Restaurant res = (Restaurant)getSession().get(Restaurant.class, resId);
		Style style = res.getStyle();
		style.setColor(newColor);
		style.setHasTime(ifhasTime);
		style.setHasOrderManager(ifhasOrderManager);
		style.setHasSpecial(ifhasSpecial);
	}

	@Override
	public String findAllEmpInRes(int resId) {
		// TODO Auto-generated method stub
		Restaurant res = (Restaurant)getSession().get(Restaurant.class, resId);
		int count = res.getEMPs().size();
		//这是后方一个很重要的方法，注意Set的使用
		System.out.println();
		return null;
	}

	@Override
	public List<Object[]> findAllRes() {
		// TODO Auto-generated method stub
		String hql = "select r.resId,r.resName from Restaurant r";
		Query query = getSession().createQuery(hql);
		List<Object[]> objs = query.list();
		for(Object[] obj:objs){
			System.out.println(Arrays.asList(obj));
		}
		return objs;
	}

	@Override
	public Restaurant returnRestaurant(Integer resId) {
		// TODO Auto-generated method stub
		try{
			String hql = "select new Restaurant(r.resId,r.resName,r.resAddress,r.resTele) from Restaurant r where r.resId = ?"; 
			Query query = getSession().createQuery(hql).setInteger(0, resId);
			Restaurant res = (Restaurant)query.uniqueResult();
			return res;
		}catch(Exception e){
			Restaurant res = null;
			return res;
		}
		
	}

	@Override
	public List<Restaurant> returnRestaurant() {
		// TODO Auto-generated method stub
		String hql = "select new Restaurant(r.resId,r.resName,r.resAddress,r.resTele)"
				+ " from Restaurant r"; 
		Query query = getSession().createQuery(hql);
		List<Restaurant> ress = query.list();
		for(Restaurant res:ress){
			System.out.println(res.getResId()+", " +res.getResName()+", "+res.getResAddress()+", "+res.getResTele());
		}
		System.out.println();
		return ress;
	}

	@Override
	public void updateRestaurantStyleById(Integer resId, String newName) {
		// TODO Auto-generated method stub
		Restaurant res = (Restaurant)getSession().get(Restaurant.class, resId);
		res.setResName(newName);
	}
	
	

}
