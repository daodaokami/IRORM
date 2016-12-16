package com.iroiro.spring.hibernate.services;

import java.util.List;
import java.util.Set;

import com.iroiro.spring.hibernate.entities.Dish;
import com.iroiro.spring.hibernate.entities.Material;

public interface DishTestService {
	public void showDishInfo(Integer dhId);
	public void showMaterialofDish(Integer dhId);
	public void addNewDish(Integer resId,String name,int price);
	public void addNewDish(Dish dh);
	public void buildRela(Integer dhId, List<Integer> mrlIds);
	
	public void updateDishPrice(Integer dhId, Integer newPrice);
	public void updateDishImg(Integer dhId, String dir);
	public void deleteDish(Integer dhId);
	
	public Dish returnDish(String dhName);
	public Dish returnDish(Integer dhId);
	public List<Dish> returnDishes(Integer resId);
	public List<Dish> returnDishes();
	
	public Set<Material> returnMrls(Integer dhId);
	public boolean checkMs(Integer resId, String name);
	public boolean setDhState0(Integer dhId);
	
	public boolean setExPro(Integer dhId, String expro);
	public String getExPro(Integer dhId);
	
}
