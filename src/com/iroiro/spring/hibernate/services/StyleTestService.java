package com.iroiro.spring.hibernate.services;

import com.iroiro.spring.hibernate.entities.Style;

public interface StyleTestService {
	public Style returnStyle(Integer resId);
	public void updateStyle(Integer resId, Integer color,boolean hasTime,boolean hasOrderManager,boolean hasSpecial);
}
