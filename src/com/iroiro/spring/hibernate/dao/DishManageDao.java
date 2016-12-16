package com.iroiro.spring.hibernate.dao;

import java.util.List;
import java.util.Set;

import com.iroiro.spring.hibernate.entities.Dish;
import com.iroiro.spring.hibernate.entities.Material;

public interface DishManageDao {
	//查找
	public String findDishNameById(int dhId);
	public int findDishPriceById(int dhId);
	public int findStateofDish(int dhId);
	public Integer findResbyDish(int dhId);
	public String getMaterialofDish(int dhId);
	
	public void buildRelawithMrl(Integer dhId, List<Integer> mrlIds);
	
	public List<Object[]> findAllDish();
	
	//插入,插入的一道菜的时候需要设置该菜需要的材料
	public void insertDish(Integer resId, String name, int price);
	public boolean checkM(Integer resId, String name);
	
	//这里这样子设计，在dish可以直接插入菜，但是要更新食谱数据，就必须访问material来确认是否有该材料
	//删除
	public void deleteDishById(int dhId);
	
	//更新
	public void updateDishPrice(Integer dhId, int newPrice);
	public void updateDishState(Integer dhId, int dhState);//可以通过查询material来确定该菜是否选
	public void updateDishIMGURL(Integer dhId, String dir);
	//订菜,预定一道菜，或者一些菜的方法
	public void proOrderofDish();
	
	public Dish returnDh(String dhName);
	public Dish returnDh(Integer dhId);
	public List<Dish> returnDhes(Integer resId);
	public List<Dish> returnDhes();
	
	public Set<Material> returnMaterials(Integer dhId);
	public void insertDish(Dish dh);
	public void setState0(Integer dhId);
	
	public boolean isDishInOrder(Integer dhId);
	
	public void setExPro(Integer dhId, String proMsg);//传入的是一个json化的字符串，还可以取出
	public String getExPro(Integer dhId);
	
}
