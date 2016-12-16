package com.iroiro.spring.hibernate.dao;

import java.util.List;

import com.iroiro.spring.hibernate.entities.Restaurant;
import com.iroiro.spring.hibernate.entities.Style;

public interface RestaurantManageDao {
	
	//查找
	public String findRestaurantNameById(int resId);
	public String findRestaurantAddressById(int resId);
	public String findRestaurantTeleById(int resId);
	public String findAllEmpInRes(int resId);
	
	public Style findRestaurantStyleById(int resId);
	
	public List<Object[]> findAllRes();
	//插入,这就是初始化一个餐馆，并初始化餐馆的style的配置信息
	public Integer insertRestaurant(String name,String addr,String tele);
	
	//删除
	public void deleteRestaurantById(int resId);
	
	//更新
	public void updateRestaurantNameById(int resId,String newResName);
	public void updateRestaurantAddressById(int resId,String newAddress);
	public void updateRestaurantTeleById(int resId,String newTele);
	public void updateRestaurantStyleById(Integer resId, int newColor,
			boolean ifhasTime,boolean ifhasOrderManager,boolean ifhasSpecial);
	public void updateRestaurantStyleById(Integer resId,String newName);
	
	public Restaurant returnRestaurant(Integer resId);
	public List<Restaurant> returnRestaurant();
}
