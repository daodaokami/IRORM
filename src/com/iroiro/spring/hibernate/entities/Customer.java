package com.iroiro.spring.hibernate.entities;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	private Integer ctmId;
	private String ctmName;
	
	private Set<Ordder> Orders = new HashSet<Ordder>();

	public Integer getCtmId() {
		return ctmId;
	}

	public void setCtmId(Integer ctmId) {
		this.ctmId = ctmId;
	}

	public String getCtmName() {
		return ctmName;
	}

	public void setCtmName(String ctmName) {
		this.ctmName = ctmName;
	}
	
	public Set<Ordder> getOrders() {
		return Orders;
	}

	public void setOrders(Set<Ordder> orders) {
		Orders = orders;
	}

	public Customer(Integer ctmId, String ctmName) {
		super();
		this.ctmId = ctmId;
		this.ctmName = ctmName;
	}
	
	public Customer(Integer ctmId, String ctmName, Set<Ordder> orders) {
		super();
		this.ctmId = ctmId;
		this.ctmName = ctmName;
		Orders = orders;
	}

	public Customer(String ctmName) {
		super();
		this.ctmName = ctmName;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [ctmId=" + ctmId + ", ctmName=" + ctmName + ", Orders=" + Orders + "]";
	}
	
	
}
