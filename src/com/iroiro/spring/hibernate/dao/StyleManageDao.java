package com.iroiro.spring.hibernate.dao;

import com.iroiro.spring.hibernate.entities.Style;

public interface StyleManageDao {
	public Style returnStyle(Integer resId);
	public void updateStyle(Integer resId, Integer color,boolean hasTime,boolean hasOrderManager,boolean hasSpecial);
}
