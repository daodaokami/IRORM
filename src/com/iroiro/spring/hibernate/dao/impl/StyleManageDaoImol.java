package com.iroiro.spring.hibernate.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iroiro.spring.hibernate.dao.StyleManageDao;
import com.iroiro.spring.hibernate.entities.Style;

@Repository
public class StyleManageDaoImol implements StyleManageDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
		//获取和当前线程绑定的session,然后就可以在下面实现一个个的方法了
	}
	
	@Override
	public Style returnStyle(Integer resId) {
		// TODO Auto-generated method stub
		try{
			String hql = "select new Style(s.styId, s.color, s.hasTime, s.hasOrderManager, s.hasSpecial)"
				+ " from Style s where s.styId = ?"; 
			Query query = getSession().createQuery(hql).setInteger(0, resId);
			Style sty = (Style)query.uniqueResult();
			return sty;//因为style根据res的主键生成
		}catch(Exception e ){
			Style sty = null;
			return sty;
		}
	}

	@Override
	public void updateStyle(Integer resId, Integer color, boolean hasTime, boolean hasOrderManager, boolean hasSpecial) {
		// TODO Auto-generated method stub
		Style style = (Style)getSession().get(Style.class, resId);
		style.setColor(color);
		style.setHasTime(hasTime);
		style.setHasOrderManager(hasOrderManager);
		style.setHasSpecial(hasSpecial);
	}

}
