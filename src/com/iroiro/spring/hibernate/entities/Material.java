package com.iroiro.spring.hibernate.entities;

public class Material {
	private Integer mrlId;
	private String mrlName;
	private Integer mrlPrice;//单价
	private Integer mrlAmount;//总数
	private String exProperties;
	
	private Restaurant restaurant;
	
	public Integer getMrlId() {
		return mrlId;
	}

	public void setMrlId(Integer mrlId) {
		this.mrlId = mrlId;
	}

	public String getMrlName() {
		return mrlName;
	}

	public void setMrlName(String mrlName) {
		this.mrlName = mrlName;
	}

	public String getExProperties() {
		return exProperties;
	}

	public void setExProperties(String exProperties) {
		this.exProperties = exProperties;
	}

	public Integer getMrlPrice() {
		return mrlPrice;
	}

	public void setMrlPrice(Integer mrlPrice) {
		this.mrlPrice = mrlPrice;
	}

	public Integer getMrlAmount() {
		return mrlAmount;
	}

	public void setMrlAmount(Integer mrlAmount) {
		this.mrlAmount = mrlAmount;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Material(Integer mrlId, String mrlName, Integer mrlPrice, Integer mrlAmount, Restaurant restaurant) {
		super();
		this.mrlId = mrlId;
		this.mrlName = mrlName;
		this.mrlPrice = mrlPrice;
		this.mrlAmount = mrlAmount;
		this.restaurant = restaurant;
	}

	public Material(String mrlName, Integer mrlPrice, Integer mrlAmount, Restaurant restaurant) {
		super();
		this.mrlName = mrlName;
		this.mrlPrice = mrlPrice;
		this.mrlAmount = mrlAmount;
		this.restaurant = restaurant;
	}
	
	

	public Material(String mrlName, Integer mrlPrice, Integer mrlAmount) {
		super();
		this.mrlName = mrlName;
		this.mrlPrice = mrlPrice;
		this.mrlAmount = mrlAmount;
	}

	public Material(Integer mrlId, String mrlName, Integer mrlPrice, Integer mrlAmount) {
		super();
		this.mrlId = mrlId;
		this.mrlName = mrlName;
		this.mrlPrice = mrlPrice;
		this.mrlAmount = mrlAmount;
	}

	public Material(String mrlName) {
		super();
		this.mrlName = mrlName;
	}
	
	public Material(Integer mrlId, String mrlName) {
		super();
		this.mrlId = mrlId;
		this.mrlName = mrlName;
	}
	public Material() {
		super();
	}

	public Material(Integer mrlId, String mrlName, Integer mrlPrice, Integer mrlAmount, String exProperties,
			Restaurant restaurant) {
		super();
		this.mrlId = mrlId;
		this.mrlName = mrlName;
		this.mrlPrice = mrlPrice;
		this.mrlAmount = mrlAmount;
		this.exProperties = exProperties;
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "Material [mrlId=" + mrlId + ", mrlName=" + mrlName + ", mrlPrice=" + mrlPrice + ", mrlAmount="
				+ mrlAmount + ", exProperties=" + exProperties + ", restaurant=" + restaurant + "]";
	}
	
	


	
}
