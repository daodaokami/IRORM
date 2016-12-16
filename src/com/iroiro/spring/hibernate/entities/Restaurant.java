package com.iroiro.spring.hibernate.entities;

import java.util.HashSet;
import java.util.Set;

public class Restaurant {
	private Integer resId;//主键
	private String resName;
	private String resAddress;
	private String resTele;
	
	private Style style;
	private Set<Employee> EMPs = new HashSet<Employee>();
	private Set<Dish> Dishes = new HashSet<Dish>();
	private Set<Material> Mrls = new HashSet<Material>();
	private Set<Ordder> Orders = new HashSet<Ordder>();

	public Integer getResId() {
		return resId;
	}

	public void setResId(Integer resId) {
		this.resId = resId;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getResAddress() {
		return resAddress;
	}

	public void setResAddress(String resAddress) {
		this.resAddress = resAddress;
	}

	public String getResTele() {
		return resTele;
	}

	public void setResTele(String resTele) {
		this.resTele = resTele;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	
	public Set<Employee> getEMPs() {
		return EMPs;
	}

	public void setEMPs(Set<Employee> eMPs) {
		EMPs = eMPs;
	}

	public Set<Dish> getDishes() {
		return Dishes;
	}

	public void setDishes(Set<Dish> dishes) {
		Dishes = dishes;
	}

	public Set<Material> getMrls() {
		return Mrls;
	}

	public void setMrls(Set<Material> mrls) {
		Mrls = mrls;
	}

	public Set<Ordder> getOrders() {
		return Orders;
	}

	public void setOrders(Set<Ordder> orders) {
		Orders = orders;
	}

	public Restaurant(Integer resId, String resName, String resAddress, String resTele, Style style) {
		super();
		this.resId = resId;
		this.resName = resName;
		this.resAddress = resAddress;
		this.resTele = resTele;
		this.style = style;
	}

	public Restaurant(String resName, String resAddress, String resTele, Style style) {
		super();
		this.resName = resName;
		this.resAddress = resAddress;
		this.resTele = resTele;
		this.style = style;
	}

	
	
	public Restaurant(String resName, String resAddress, String resTele) {
		super();
		this.resName = resName;
		this.resAddress = resAddress;
		this.resTele = resTele;
	}
	

	public Restaurant(Integer resId, String resName, String resAddress, String resTele) {
		super();
		this.resId = resId;
		this.resName = resName;
		this.resAddress = resAddress;
		this.resTele = resTele;
	}

	public Restaurant() {
		super();
	}

	@Override
	public String toString() {
		return "Restaurant [resId=" + resId + ", resName=" + resName + ", resAddress=" + resAddress + ", resTele="
				+ resTele + ", style=" + style + ", EMPs=" + EMPs + ", Dishes=" + Dishes + ", Mrls=" + Mrls
				+ ", Orders=" + Orders + "]";
	}
	
	
	
	
}
