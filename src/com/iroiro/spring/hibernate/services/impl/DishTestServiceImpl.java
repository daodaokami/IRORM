package com.iroiro.spring.hibernate.services.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iroiro.spring.hibernate.dao.DishManageDao;
import com.iroiro.spring.hibernate.entities.Dish;
import com.iroiro.spring.hibernate.entities.Material;
import com.iroiro.spring.hibernate.services.DishTestService;

@Service
public class DishTestServiceImpl implements DishTestService {

	@Autowired
	DishManageDao dmd;
	
	@Override
	public void showDishInfo(Integer dhId) {
		// TODO Auto-generated method stub
		String dhInfo = "菜名：" + dmd.findDishNameById(dhId);
		dhInfo += ("菜价：" + dmd.findDishPriceById(dhId));
		dhInfo += ("状态：" + dmd.findStateofDish(dhId));
		dhInfo += ("所属：" + dmd.findResbyDish(dhId));
		System.out.println(dhInfo);
	}

	@Override
	public void showMaterialofDish(Integer dhId) {
		// TODO Auto-generated method stub
		System.out.println(dmd.getMaterialofDish(dhId));
	}

	@Override
	public void addNewDish(Integer resId, String name, int price) {
		// TODO Auto-generated method stub
		dmd.insertDish(resId, name, price);
	}
	
	@Override
	public void addNewDish(Dish dh) {
		// TODO Auto-generated method stub
		dmd.insertDish(dh);
	}

	@Override
	public void deleteDish(Integer dhId) {
		// TODO Auto-generated method stub
		dmd.deleteDishById(dhId);//
	}

	@Override
	public void buildRela(Integer dhId, List<Integer> mrlIds) {
		// TODO Auto-generated method stub
		dmd.buildRelawithMrl(dhId, mrlIds);
	}

	@Override
	public Dish returnDish(Integer dhId) {
		// TODO Auto-generated method stub
		return dmd.returnDh(dhId);
	}
	@Override
	public Dish returnDish(String dhName) {
		// TODO Auto-generated method stub
		return dmd.returnDh(dhName);
	}
	@Override
	public List<Dish> returnDishes(Integer resId) {
		// TODO Auto-generated method stub
		return dmd.returnDhes(resId);
	}

	@Override
	public List<Dish> returnDishes() {
		// TODO Auto-generated method stub
		return dmd.returnDhes();
	}

	@Override
	public void updateDishPrice(Integer dhId, Integer newPrice) {
		// TODO Auto-generated method stub
		dmd.updateDishPrice(dhId, newPrice);
	}

	@Override
	public void updateDishImg(Integer dhId, String dir) {
		// TODO Auto-generated method stub
		dmd.updateDishIMGURL(dhId, dir);
	}

	@Override
	public Set<Material> returnMrls(Integer dhId) {
		// TODO Auto-generated method stub
		return dmd.returnMaterials(dhId);
	}

	@Override
	public boolean checkMs(Integer resId, String name) {
		// TODO Auto-generated method stub
		return dmd.checkM(resId, name);
	}

	@Override
	public boolean setDhState0(Integer dhId) {
		// TODO Auto-generated method stub
		try{
			dmd.setState0(dhId);
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public boolean setExPro(Integer dhId, String expro) {
		// TODO Auto-generated method stub
		try{
			dmd.setExPro(dhId, expro);
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public String getExPro(Integer dhId) {
		// TODO Auto-generated method stub
		return dmd.getExPro(dhId);
	}

}
