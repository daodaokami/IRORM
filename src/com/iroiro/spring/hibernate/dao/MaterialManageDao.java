package com.iroiro.spring.hibernate.dao;

import java.util.List;

import com.iroiro.spring.hibernate.entities.Material;

public interface MaterialManageDao {
	//查找
	public String findMaterialNameById(int mrlId);
	public int findMaterialPriceById(int mrlId);
	public int findMaterialAmountById(int mrlId);
	public int findRestaurantIdBymrlId(int mrlId);//这是材料对应的餐厅
	
	public List<Object[]> findAllMrl();
	public List<Object[]> findAllMrlByResId(Integer resId);
	//插入
	public void insertMaterial(Integer resId, String name, int price, int amount);
	public void insertMaterial(Integer resId, String name);
	public void insertMaterial(Integer resId, Material mrl);
	//删除
	public void deleteMaterialById(int mrlId);
			
	//更新
	public void updateMaterialPrice(int mrlId,int newPrice);
	public void updateMaterialAmount2(int mrlId,int amount);
	public void updateMaterialAmount(int mrlId,int addAmount);
	
	public Material returnMrl(Integer mrlId);
	public List<Material> returnMrls(Integer resId);
	public List<Material> returnMrls();
	
	public Material returnMrl(Integer resId, String mrlName);
	
	public void setExPro(Integer mrlId, String expro);
	public String getExpro(Integer mrlId);
}
