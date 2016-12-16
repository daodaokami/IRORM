package com.iroiro.spring.hibernate.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iroiro.spring.hibernate.dao.StyleManageDao;
import com.iroiro.spring.hibernate.entities.Style;
import com.iroiro.spring.hibernate.services.StyleTestService;

@Service
public class StyleTestServiceImpl implements StyleTestService {

	@Autowired
	StyleManageDao smd;
	@Override
	public Style returnStyle(Integer resId) {
		// TODO Auto-generated method stub
		return smd.returnStyle(resId);
	}

	@Override
	public void updateStyle(Integer resId, Integer color, boolean hasTime, boolean hasOrderManager, boolean hasSpecial) {
		// TODO Auto-generated method stub
		smd.updateStyle(resId, color, hasTime, hasOrderManager, hasSpecial);
	}

}
