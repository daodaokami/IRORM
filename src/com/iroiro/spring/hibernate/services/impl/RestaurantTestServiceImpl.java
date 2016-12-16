package com.iroiro.spring.hibernate.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iroiro.spring.hibernate.dao.RestaurantManageDao;
import com.iroiro.spring.hibernate.entities.Restaurant;
import com.iroiro.spring.hibernate.entities.Style;
import com.iroiro.spring.hibernate.services.RestaurantTestService;

@Service
public class RestaurantTestServiceImpl implements RestaurantTestService{

	@Autowired
	RestaurantManageDao rmd;
	
	@Override
	public void showResInfo(Integer resId) {
		// TODO Auto-generated method stub
		String resInfo ="餐厅：" + rmd.findRestaurantNameById(resId);
		resInfo = resInfo + " , 地址：" + rmd.findRestaurantAddressById(resId);
		resInfo = resInfo + " , 电话：" + rmd.findRestaurantTeleById(resId);
		System.out.println(resInfo);
	}

	@Override
	public void showResStyleInfo(Integer resId) {
		// TODO Auto-generated method stub
		Style style = rmd.findRestaurantStyleById(resId);
		System.out.println(style);
	}

	@Override
	public void showAllEmpInRes(Integer resId) {
		// TODO Auto-generated method stub
		rmd.findAllEmpInRes(resId);
	}
	
	@Override
	public void showAllRes(){
		rmd.findAllRes();
	}
	
	@Override
	public Integer saveNewRes(String resName, String resAddress, String resTele) {
		// TODO Auto-generated method stub
		Integer flag = rmd.insertRestaurant(resName, resAddress, resTele);
		if(flag==1)
			System.out.println("保存成功");
		else{
			System.out.println("重复注册");
		}
		return flag;
	}

	@Override
	public void deleteOldRes(Integer resId) {
		// TODO Auto-generated method stub
		rmd.deleteRestaurantById(resId);
		System.out.println("连级删除");
	}

	@Override
	public void updateResInfo(Integer resId, String newName, String newAddress, String newTele) {
		// TODO Auto-generated method stub
		rmd.updateRestaurantNameById(resId, newName);
		rmd.updateRestaurantAddressById(resId, newAddress);
		rmd.updateRestaurantTeleById(resId, newTele);
	}

	@Override
	public void updateResStyle(Integer resId,int newColor, boolean ifhasTime, boolean ifhasOrderManager, boolean ifhasSpecial) {
		// TODO Auto-generated method stub
		rmd.updateRestaurantStyleById(resId, newColor, ifhasTime, ifhasOrderManager, ifhasSpecial);
	}

	@Override
	public Restaurant returnRes(Integer resId) {
		// TODO Auto-generated method stub
		return rmd.returnRestaurant(resId);
	}

	@Override
	public List<Restaurant> returnRess() {
		// TODO Auto-generated method stub
		return rmd.returnRestaurant();
	}

	@Override
	public void updateResInfo(Integer resId, String newName) {
		// TODO Auto-generated method stub
		rmd.updateRestaurantNameById(resId, newName);
	}

	
	

}
