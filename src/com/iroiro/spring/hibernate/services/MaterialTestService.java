package com.iroiro.spring.hibernate.services;

import java.util.List;

import com.iroiro.spring.hibernate.entities.Material;

public interface MaterialTestService {
	public void showMaterialInfo(Integer mrlId);
	public void addMaterial(Integer resId, String mrlName, int price, int amount);
	public void addMaterial(Integer resId, String mrlName);
	public void addMaterial(Integer resId, Material mrl);
	
	public void showAllMrl();
	public void showAllMrlByRes(Integer resId);
	
	public Material returnMrl(Integer mrlId);
	public List<Material> returnMrls(Integer resId);
	public List<Material> returnMrls();
	public Material returnMrl(Integer resId, String mrlName);
	
	public void updateMaterialAmount(Integer mrlId, int addAmount);
	public void updateMaterialAmount2(Integer mrlId, int Amount);

	public boolean setExPro(Integer mrlId, String expro);
	public String getExPro(Integer mrlId);
}
