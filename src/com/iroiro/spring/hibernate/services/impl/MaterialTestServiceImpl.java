package com.iroiro.spring.hibernate.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iroiro.spring.hibernate.dao.MaterialManageDao;
import com.iroiro.spring.hibernate.entities.Material;
import com.iroiro.spring.hibernate.services.MaterialTestService;

@Service
public class MaterialTestServiceImpl implements MaterialTestService{

	@Autowired
	MaterialManageDao mmd;
	
	@Override
	public void showMaterialInfo(Integer mrlId) {
		// TODO Auto-generated method stub
		String mrlInfo = "材料名：" + mmd.findMaterialNameById(mrlId);
		mrlInfo += ("，材料价格：" + mmd.findMaterialPriceById(mrlId));
		mrlInfo += ("，材料总量：" + mmd.findMaterialAmountById(mrlId));
		mrlInfo += ("，所属餐馆：" + mmd.findRestaurantIdBymrlId(mrlId));
		System.out.println(mrlInfo);
	}

	@Override
	public void addMaterial(Integer resId, String mrlName, int price, int amount) {
		// TODO Auto-generated method stub
		mmd.insertMaterial(resId, mrlName, price, amount);
	}
	@Override
	public void addMaterial(Integer resId, String mrlName) {
		// TODO Auto-generated method stub
		mmd.insertMaterial(resId, mrlName);
	}
	
	@Override
	public void addMaterial(Integer resId, Material mrl) {
		// TODO Auto-generated method stub
		mmd.insertMaterial(resId, mrl);
	}
	@Override
	public void showAllMrl(){
		mmd.findAllMrl();
	}

	@Override
	public void showAllMrlByRes(Integer resId) {
		// TODO Auto-generated method stub
		mmd.findAllMrlByResId(resId);
	}

	@Override
	public Material returnMrl(Integer mrlId) {
		// TODO Auto-generated method stub
		
		return mmd.returnMrl(mrlId);
	}

	@Override
	public Material returnMrl(Integer resId, String mrlName) {
		// TODO Auto-generated method stub
		
		return mmd.returnMrl(resId, mrlName);
	}
	
	@Override
	public List<Material> returnMrls(Integer resId) {
		// TODO Auto-generated method stub
		return mmd.returnMrls(resId);
	}
	
	@Override
	public List<Material> returnMrls() {
		// TODO Auto-generated method stub
		return mmd.returnMrls();
	}

	@Override
	public void updateMaterialAmount(Integer mrlId, int addAmount) {
		// TODO Auto-generated method stub
		mmd.updateMaterialAmount(mrlId, addAmount);
	}

	@Override
	public void updateMaterialAmount2(Integer mrlId, int Amount) {
		// TODO Auto-generated method stub
		mmd.updateMaterialAmount2(mrlId, Amount);

	}

	@Override
	public boolean setExPro(Integer mrlId, String expro) {
		// TODO Auto-generated method stub
		try{
			mmd.setExPro(mrlId, expro);
		}catch(Exception e){
			return false;
		}
		return true;
		
	}

	@Override
	public String getExPro(Integer mrlId) {
		// TODO Auto-generated method stub
		return mmd.getExpro(mrlId);
	}
	
}
