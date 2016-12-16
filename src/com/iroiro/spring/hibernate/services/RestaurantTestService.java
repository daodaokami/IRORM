package com.iroiro.spring.hibernate.services;

import java.util.List;

import com.iroiro.spring.hibernate.entities.Restaurant;

public interface RestaurantTestService {
	public void showResInfo(Integer resId);
	public void showResStyleInfo(Integer resId);
	public void showAllEmpInRes(Integer resId);
	public void showAllRes();
	
	public Integer saveNewRes(String resName,String resAddress,String resTele);
	public void deleteOldRes(Integer resId);
	public void updateResInfo(Integer resId, String newName,String newAddress,String newTele);
	public void updateResStyle(Integer resId, int newColor, boolean ifhasTime, boolean ifhasOrderManager,
			boolean ifhasSpecial);
	public void updateResInfo(Integer resId,String newName);
	
	public Restaurant returnRes(Integer resId);
	public List<Restaurant> returnRess();
}
