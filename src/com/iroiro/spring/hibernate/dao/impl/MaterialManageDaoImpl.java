package com.iroiro.spring.hibernate.dao.impl;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iroiro.spring.hibernate.dao.MaterialManageDao;
import com.iroiro.spring.hibernate.entities.Employee;
import com.iroiro.spring.hibernate.entities.Material;
import com.iroiro.spring.hibernate.entities.Restaurant;

@Repository
public class MaterialManageDaoImpl implements MaterialManageDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
		//获取和当前线程绑定的session,然后就可以在下面实现一个个的方法了
	}

	
	@Override
	public String findMaterialNameById(int mrlId) {
		// TODO Auto-generated method stub
		String hql = "select m.mrlName from Material m where m.mrlId = ?";
		Query query = getSession().createQuery(hql).setInteger(0, mrlId);
		return (String)query.uniqueResult();
	}

	@Override
	public int findMaterialPriceById(int mrlId) {
		// TODO Auto-generated method stub
		String hql = "select m.mrlPrice from Material m where m.mrlId = ?";
		Query query = getSession().createQuery(hql).setInteger(0, mrlId);
		return (int)query.uniqueResult();
	}

	@Override
	public int findMaterialAmountById(int mrlId) {
		// TODO Auto-generated method stub
		String hql = "select m.mrlAmount from Material m where m.mrlId = ?";
		Query query = getSession().createQuery(hql).setInteger(0, mrlId);
		return (int)query.uniqueResult();
	}

	@Override
	public int findRestaurantIdBymrlId(int mrlId) {
		// TODO Auto-generated method stub
		String hql = "select m.restaurant.resId from Material m where m.mrlId = ?";
		Query query = getSession().createQuery(hql).setInteger(0, mrlId);
		return (int)query.uniqueResult();
	}

	@Override
	public void insertMaterial(Integer resId, String name) {
		// TODO Auto-generated method stub
		Material mrl = new Material(name);
		Restaurant res = (Restaurant)getSession().get(Restaurant.class, resId);
		mrl.setRestaurant(res);
		String hql = "select new Material(m.mrlId,m.mrlName) from Material m where m.restaurant.resId = ? and m.mrlName = ?";
		Query query = getSession().createQuery(hql).setInteger(0, resId).setString(1, name);
		Material mrlT = (Material) query.uniqueResult();
		System.out.println(mrlT);
		//如果是空的则会报错，没有报错的话就会直接建立与dish的联系
		if(mrlT != null){
			System.out.println("存在直接联系");
		}
		else{//不为空
			System.out.println("不存在，新建mrl后建立联系");
		}
		
		
	}
	
	
	@Override
	public void insertMaterial(Integer resId, String name, int price, int amount) {
		// TODO Auto-generated method stub
		Material mrl = new Material(name,price,amount);
		Restaurant res = (Restaurant)getSession().get(Restaurant.class, resId);
		mrl.setRestaurant(res);
		
		getSession().save(mrl);
	}

	@Override
	public void deleteMaterialById(int mrlId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMaterialPrice(int mrlId, int newPrice) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMaterialAmount(int mrlId, int addAmount) {
		// TODO Auto-generated method stub
		Material mrl = (Material) getSession().get(Material.class, mrlId);
		int curAmount = mrl.getMrlAmount();
		mrl.setMrlAmount(addAmount+curAmount);
	}
	@Override
	public void updateMaterialAmount2(int mrlId, int amount) {
		// TODO Auto-generated method stub
		Material mrl = (Material) getSession().get(Material.class, mrlId);
		mrl.setMrlAmount(amount);
	}


	@Override
	public List<Object[]> findAllMrl() {
		// TODO Auto-generated method stub
		String hql = "select m.mrlId,m.mrlName,m.mrlPrice,m.mrlAmount from Material m";
		Query query = getSession().createQuery(hql);
		List<Object[]> objs = query.list();
		for(Object[] obj:objs){
			System.out.println(Arrays.asList(obj));
		}
		return objs;
	}


	@Override
	public List<Object[]> findAllMrlByResId(Integer resId) {
		// TODO Auto-generated method stub
		String hql = "select m.mrlId,m.mrlName,m.mrlPrice,m.mrlAmount from Material m "
				+ "where m.restaurant.resId = ?";
		Query query = getSession().createQuery(hql).setInteger(0, resId);
		List<Object[]> objs = query.list();
		for(Object[] obj:objs){
			System.out.println(Arrays.asList(obj));
		}
		return objs;
	}


	@Override
	public Material returnMrl(Integer mrlId) {
		// TODO Auto-generated method stub
		String hql = "select new Material(m.mrlId,m.mrlName,m.mrlPrice,m.mrlAmount) from Material m where m.mrlId = ?"; 
		Query query = getSession().createQuery(hql).setInteger(0, mrlId);
		Material mrl = null;
		try{
			mrl = (Material)query.uniqueResult();
		}catch(Exception e){
			System.out.println("nullpointException");
			return null;
		}
		return mrl;
	}
	@Override
	public List<Material> returnMrls(Integer resId) {
		String hql = "select new Material(m.mrlId,m.mrlName,m.mrlPrice,m.mrlAmount)"
				+ " from Material m where m.restaurant.resId = ?"; 
		Query query = getSession().createQuery(hql).setInteger(0, resId);
		List<Material> mrls = query.list();
		for(Material mrl:mrls){
			System.out.println(mrl.getMrlId()+", " +mrl.getMrlName()+", "+mrl.getMrlPrice());
		}
		System.out.println();
		return mrls;
	}
	@Override
	public List<Material> returnMrls() {
		// TODO Auto-generated method stub
		String hql = "select new Material(m.mrlId,m.mrlName,m.mrlPrice,m.mrlAmount)"
				+ " from Material m"; 
		Query query = getSession().createQuery(hql);
		List<Material> mrls = query.list();
		for(Material mrl:mrls){
			System.out.println(mrl.getMrlId()+", " +mrl.getMrlName()+", "+mrl.getMrlPrice());
		}
		System.out.println();
		return mrls;
	}


	@Override
	public void insertMaterial(Integer resId, Material mrl) {
		// TODO Auto-generated method stub
		Restaurant res = (Restaurant)getSession().get(Restaurant.class, resId);
		mrl.setRestaurant(res);
		getSession().save(mrl);
	}
	
	@Override
	public Material returnMrl(Integer resId, String mrlName){
		String hql = "select new Material(m.mrlId,m.mrlName,m.mrlPrice,m.mrlAmount) from Material m where m.restaurant.resId = ? and m.mrlName = ?"; 
		Query query = getSession().createQuery(hql).setInteger(0, resId).setString(1, mrlName);
		Material mrl = null;
		try{
			mrl = (Material)query.uniqueResult();
		}catch(Exception e){
			System.out.println("returnMrl nopointException");
			return null;
		}
		return mrl;
	}


	@Override
	public void setExPro(Integer mrlId, String expro) {
		// TODO Auto-generated method stub
		String hql = "update Material m set m.exProperties = ? where m.mrlId = ?";
		getSession().createQuery(hql).setString(0, expro).setInteger(1, mrlId).executeUpdate();
	}


	@Override
	public String getExpro(Integer mrlId) {
		// TODO Auto-generated method stub
		String hql = "select m.exProperties from Material m where m.mrlId = ?";
		Query query = getSession().createQuery(hql).setInteger(0, mrlId);
		String expro = (String)query.uniqueResult();
		return expro;
	}
	

}
