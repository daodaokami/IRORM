package com.iroiro.spring.hibernate.dao.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iroiro.spring.hibernate.dao.DishManageDao;
import com.iroiro.spring.hibernate.entities.Dish;
import com.iroiro.spring.hibernate.entities.Material;
import com.iroiro.spring.hibernate.entities.Restaurant;

@Repository
public class DishManageDaoImpl implements DishManageDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
		//获取和当前线程绑定的session,然后就可以在下面实现一个个的方法了
	}
	
	@Override
	public String findDishNameById(int dhId) {
		// TODO Auto-generated method stub
		String hql = "select d.dhName from Dish d where d.dhId = ?";
		Query query = getSession().createQuery(hql).setInteger(0, dhId);
		return (String)query.uniqueResult();
		
	}

	@Override
	public int findDishPriceById(int dhId) {
		// TODO Auto-generated method stub
		String hql = "select d.dhPrice from Dish d where d.dhId = ?";
		Query query = getSession().createQuery(hql).setInteger(0, dhId);
		return (int)query.uniqueResult();
	}

	@Override
	public int findStateofDish(int dhId) {
		// TODO Auto-generated method stub
		String hql = "select d.dhState from Dish d where d.dhId = ?";
		Query query = getSession().createQuery(hql).setInteger(0, dhId);
		return (int)query.uniqueResult();
	}

	@Override
	public Integer findResbyDish(int dhId) {
		// TODO Auto-generated method stub
		Dish dh = (Dish)getSession().get(Dish.class, dhId);
		Restaurant res = dh.getRestaurant();
		return res.getResId();
	}
	
	@Override
	public List<Object[]> findAllDish(){
		String hql = "select d.dhId,d.dhName from Dish d";
		Query query = getSession().createQuery(hql);
		List<Object[]> objs = query.list();
		for(Object[] obj:objs){
			System.out.println(Arrays.asList(obj));
		}
		return objs;
	}

	@Override
	public String getMaterialofDish(int dhId){
		Dish dh = (Dish)getSession().get(Dish.class, dhId);
		Set<Material> materials = dh.getMaterials();
		String dhInfo = "";
		for(Iterator<Material> iternator = materials.iterator();iternator.hasNext();){
			dhInfo += iternator.next().getMrlName()+" ";
		}
		return dhInfo;
	}
	
	@Override
	public void insertDish(Integer resId, String name, int price) {
		// TODO Auto-generated method stub
		Dish dh = new Dish(name,price,0);
		Restaurant res = (Restaurant)getSession().get(Restaurant.class, resId);
		dh.setRestaurant(res);
		getSession().save(dh);
	}

	@Override
	public void deleteDishById(int dhId) {
		// TODO Auto-generated method stub
		Dish dh = (Dish)getSession().get(Dish.class, dhId);
		//删掉dh之前要把dh相关联的dh_mrl表中的对应关系删除掉
		//这里怎么设置，怎么表示这个中间表
		getSession().delete(dh);
	}

	@Override
	public void updateDishPrice(Integer dhId, int newPrice) {
		// TODO Auto-generated method stub
		String hql = "update Dish d set d.dhPrice = ? where d.dhId = ?";
		getSession().createQuery(hql).setInteger(0, newPrice).setInteger(1, dhId).executeUpdate();

	}
	
	@Override
	public void updateDishState(Integer dhId, int dhState) {
		// TODO Auto-generated method stub
		String hql = "update Dish d set d.dhState = ? where d.dhId = ?";
		getSession().createQuery(hql).setInteger(0, dhState).setInteger(1, dhId).executeUpdate();
	}

	@Override
	public void proOrderofDish() {//这是一个产生订单的函数
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buildRelawithMrl(Integer dhId, List<Integer> mrlIds) {
		// TODO Auto-generated method stub
		Material mrl;
		Dish dh = (Dish)getSession().get(Dish.class, dhId);
		for(Integer mrlId :mrlIds){
			mrl = (Material)getSession().get(Material.class, mrlId);
			dh.getMaterials().add(mrl);
		}
	}

	@Override
	public Dish returnDh(Integer dhId) {
		// TODO Auto-generated method stub
		String hql = "select new Dish(d.dhId,d.dhName,d.dhPrice,d.dhState)"
				+ " from Dish d where d.dhId = ?"; 
		Query query = getSession().createQuery(hql).setInteger(0, dhId);
		Dish dh = (Dish)query.uniqueResult();
		return dh;
	}

	@Override
	public Dish returnDh(String dhName) {
		// TODO Auto-generated method stub
		String hql = "select new Dish(d.dhId,d.dhName,d.dhPrice,d.dhState)"
				+ " from Dish d where d.dhName = ?"; 
		Query query = getSession().createQuery(hql).setString(0, dhName);
		Dish dh = (Dish)query.uniqueResult();
		return dh;
	}
	@Override
	public List<Dish> returnDhes(Integer resId) {
		// TODO Auto-generated method stub
		String hql = "select new Dish(d.dhId,d.dhName,d.dhPrice,d.dhState)"
				+ " from Dish d where d.restaurant.resId = ?"; 
		Query query = getSession().createQuery(hql).setInteger(0, resId);
		List<Dish> dhes = query.list();
		/*for(int i=0;i<dhes.size();i++){
			Dish dh = (Dish)getSession().get(Dish.class, dhes.get(i).getDhId());
			Set<Material> materials = dh.getMaterials();
			dhes.get(i).setMaterials(materials);
		}*/
		return dhes;
	}

	@Override
	public List<Dish> returnDhes() {
		// TODO Auto-generated method stub
		String hql = "select new Dish(d.dhId,d.dhName,d.dhPrice,d.dhState)"
				+ " from Dish d"; 
		Query query = getSession().createQuery(hql);
		List<Dish> dhes = query.list();
		return dhes;
	}

	@Override
	public void updateDishIMGURL(Integer dhId, String dir) {
		// TODO Auto-generated method stub
		String hql = "update Dish d set d.imgURL = ? where d.dhId = ?";
		getSession().createQuery(hql).setString(0, dir).setInteger(1, dhId).executeUpdate();
	}

	@Override
	public Set<Material> returnMaterials(Integer dhId) {
		// TODO Auto-generated method stub
		Dish dh = (Dish)getSession().get(Dish.class, dhId);
		Set<Material> materials = dh.getMaterials();
		Set<Material> materialss = new HashSet<Material>();
		for(Iterator<Material> iternator = materials.iterator();iternator.hasNext();){
			Material mrl = new Material(iternator.next().getMrlName());
			materialss.add(mrl);
		}
		return materialss;
	}

	@Override
	public boolean checkM(Integer resId, String name) {
		// TODO Auto-generated method stub
		String hql = "select new Dish(d.dhName) from Dish d where d.restaurant.resId = ? and d.dhName = ?";
		Query query = getSession().createQuery(hql).setInteger(0, resId).setString(1, name);
		try{
			Dish dh = (Dish)query.uniqueResult();
			if(dh == null)
				return false;
			else{
				return true;
			}
		}catch(Exception e){
			System.out.println("出错！！！！！！！");
			return false;
		}
			
	}

	@Override
	public void insertDish(Dish dh) {
		// TODO Auto-generated method stub
		getSession().save(dh);
	}

	@Override
	public void setState0(Integer dhId) {
		// TODO Auto-generated method stub
		String hql = "update Dish d set d.dhState = 0 where d.dhId = ? ";
		getSession().createQuery(hql).setInteger(0, dhId).executeUpdate();
	}

	@Override
	public boolean isDishInOrder(Integer dhId){
		return false;
	}
	@Override
	public void setExPro(Integer dhId, String proMsg) {
		// TODO Auto-generated method stub
		String hql = "update Dish d set d.exProperties = ? where d.dhId = ?";
		getSession().createQuery(hql).setString(0, proMsg).setInteger(1, dhId).executeUpdate();
	}

	@Override
	public String getExPro(Integer dhId) {
		// TODO Auto-generated method stub
		String hql = "select d.exProperties from Dish d where d.dhId = ?";
		Query query = getSession().createQuery(hql).setInteger(0, dhId);
		String expro = (String)query.uniqueResult();
		return expro;
	}
	

}
