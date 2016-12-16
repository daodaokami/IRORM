package com.iroiro.spring.hibernate.entities;

public class Style {
	private Integer styId;
	private Integer color;
	private Boolean hasTime;
	private Boolean hasOrderManager;
	private Boolean hasSpecial;
	
	private Restaurant restaurant;

	public Integer getStyId() {
		return styId;
	}

	public void setStyId(Integer styId) {
		this.styId = styId;
	}

	public Integer getColor() {
		return color;
	}

	public void setColor(Integer color) {
		this.color = color;
	}

	public Boolean getHasTime() {
		return hasTime;
	}

	public void setHasTime(Boolean hasTime) {
		this.hasTime = hasTime;
	}

	public Boolean getHasOrderManager() {
		return hasOrderManager;
	}

	public void setHasOrderManager(Boolean hasOrderManager) {
		this.hasOrderManager = hasOrderManager;
	}

	public Boolean getHasSpecial() {
		return hasSpecial;
	}

	public void setHasSpecial(Boolean hasSpecial) {
		this.hasSpecial = hasSpecial;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Style(Integer styId, Integer color, Boolean hasTime, Boolean hasOrderManager, Boolean hasSpecial,
			Restaurant restaurant) {
		super();
		this.styId = styId;
		this.color = color;
		this.hasTime = hasTime;
		this.hasOrderManager = hasOrderManager;
		this.hasSpecial = hasSpecial;
		this.restaurant = restaurant;
	}

	public Style(Integer color, Boolean hasTime, Boolean hasOrderManager, Boolean hasSpecial,
			Restaurant restaurant) {
		super();
		this.color = color;
		this.hasTime = hasTime;
		this.hasOrderManager = hasOrderManager;
		this.hasSpecial = hasSpecial;
		this.restaurant = restaurant;
	}

	
	
	public Style(Integer color, Boolean hasTime, Boolean hasOrderManager, Boolean hasSpecial) {
		super();
		this.color = color;
		this.hasTime = hasTime;
		this.hasOrderManager = hasOrderManager;
		this.hasSpecial = hasSpecial;
	}

	public Style(Integer styId, Integer color, Boolean hasTime, Boolean hasOrderManager, Boolean hasSpecial) {
		super();
		this.styId = styId;
		this.color = color;
		this.hasTime = hasTime;
		this.hasOrderManager = hasOrderManager;
		this.hasSpecial = hasSpecial;
	}

	public Style() {
		super();
	}

	@Override
	public String toString() {
		return "Style [styId=" + styId + ", color=" + color + ", hasTime=" + hasTime + ", hasOrderManager="
				+ hasOrderManager + ", hasSpecial=" + hasSpecial + ", restaurant=" + restaurant + "]";
	}
	
	
	
	
}
