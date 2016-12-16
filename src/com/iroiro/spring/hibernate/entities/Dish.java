package com.iroiro.spring.hibernate.entities;

import java.util.HashSet;
import java.util.Set;

public class Dish {//多
	private Integer dhId;
	private String dhName;
	private Integer dhPrice;
	private Integer dhState;//记录该dish是否可选,0不可选，1可选，>1推荐
	private String imgURL;
	private String exProperties;//使用json的格式存储客户自定义的数据属性
	
	Restaurant restaurant;
	Set<Material> materials = new HashSet<Material>();
	
	public String getExProperties() {
		return exProperties;
	}
	public void setExProperties(String exProperties) {
		this.exProperties = exProperties;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	
	public Integer getDhId() {
		return dhId;
	}
	public void setDhId(Integer dhId) {
		this.dhId = dhId;
	}
	public String getDhName() {
		return dhName;
	}
	public void setDhName(String dhName) {
		this.dhName = dhName;
	}
	public Integer getDhPrice() {
		return dhPrice;
	}
	public void setDhPrice(Integer dhPrice) {
		this.dhPrice = dhPrice;
	}
	public Integer getDhState() {
		return dhState;
	}
	public void setDhState(Integer dhState) {
		this.dhState = dhState;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Set<Material> getMaterials() {
		return materials;
	}

	
	public Dish(String dhName, Integer dhPrice, Integer dhState) {
		super();
		this.dhName = dhName;
		this.dhPrice = dhPrice;
		this.dhState = dhState;
	}
	public Dish() {
		super();
	}
	public Dish(String dhName) {
		super();
		this.dhName = dhName;
	}
	
	public Dish(Integer dhId, String dhName, Integer dhPrice, Integer dhState) {
		super();
		this.dhId = dhId;
		this.dhName = dhName;
		this.dhPrice = dhPrice;
		this.dhState = dhState;
	}
	
	public Dish(String dhName, Integer dhPrice){
		super();
		this.dhName = dhName;
		this.dhPrice = dhPrice;
	}
	
	public Dish(Integer dhId, String dhName, Integer dhPrice, Integer dhState, Set<Material> materials) {
		super();
		this.dhId = dhId;
		this.dhName = dhName;
		this.dhPrice = dhPrice;
		this.dhState = dhState;
		this.materials = materials;
	}
	
	public Dish(Integer dhId, String dhName, Integer dhPrice, Integer dhState, String imgURL, String exProperties) {
		super();
		this.dhId = dhId;
		this.dhName = dhName;
		this.dhPrice = dhPrice;
		this.dhState = dhState;
		this.imgURL = imgURL;
		this.exProperties = exProperties;
	}
	public Dish(String dhName, Integer dhPrice, Integer dhState, String imgURL, String exProperties) {
		super();
		this.dhName = dhName;
		this.dhPrice = dhPrice;
		this.dhState = dhState;
		this.imgURL = imgURL;
		this.exProperties = exProperties;
	}
	public void setMaterials(Set<Material> materials) {
		this.materials = materials;
	}
	@Override
	public String toString() {
		return "Dish [dhId=" + dhId + ", dhName=" + dhName + ", dhPrice=" + dhPrice + ", dhState=" + dhState
				+ ", imgURL=" + imgURL + ", exProperties=" + exProperties + ", restaurant=" + restaurant
				+ ", materials=" + materials + "]";
	}
	
	
}
