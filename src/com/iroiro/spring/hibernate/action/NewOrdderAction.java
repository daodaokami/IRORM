package com.iroiro.spring.hibernate.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iroiro.spring.hibernate.entities.Customer;
import com.iroiro.spring.hibernate.entities.Dish;
import com.iroiro.spring.hibernate.entities.Employee;
import com.iroiro.spring.hibernate.entities.Restaurant;
import com.iroiro.spring.hibernate.services.CustomerTestService;
import com.iroiro.spring.hibernate.services.DishTestService;
import com.iroiro.spring.hibernate.services.EmployeeTestService;
import com.iroiro.spring.hibernate.services.MaterialTestService;
import com.iroiro.spring.hibernate.services.OrderTestService;
import com.iroiro.spring.hibernate.services.RestaurantTestService;
import com.iroiro.spring.hibernate.services.StyleTestService;
import com.opensymphony.xwork2.ActionContext;


public class NewOrdderAction implements RequestAware{
	
	private Map<String, Object> requestMap = null;
	
	private Date date;
	private int ctmTable;
	
	private Integer resId;
	private Integer ctmId;
	private Integer empId;
	private List<Integer> dhIds = new ArrayList<Integer>();
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCtmTable() {
		return ctmTable;
	}

	public void setCtmTable(int ctmTable) {
		this.ctmTable = ctmTable;
	}

	public Integer getResId() {
		return resId;
	}

	public void setResId(Integer resId) {
		this.resId = resId;
	}

	public Integer getCtmId() {
		return ctmId;
	}

	public void setCtmId(Integer ctmId) {
		this.ctmId = ctmId;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public List<Integer> getDhIds() {
		return dhIds;
	}

	public void setDhIds(List<Integer> dhIds) {
		this.dhIds = dhIds;
	}

	private ApplicationContext ctx = null;
	private RestaurantTestService rts = null;
	private EmployeeTestService ets = null;
	private DishTestService dts = null;
	private OrderTestService ots = null;
	private CustomerTestService cts = null;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		rts = ctx.getBean(RestaurantTestService.class);
		ets = ctx.getBean(EmployeeTestService.class);
		dts = ctx.getBean(DishTestService.class);
		ots = ctx.getBean(OrderTestService.class);
		cts = ctx.getBean(CustomerTestService.class);
	}
	
	@SuppressWarnings("unchecked")
	
	public String save(){
		this.date = new Date();
		//System.out.println("this"+this);
		
		
		
		return "input";
	}
	//给一系列的dhId，作为菜单列表

	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.requestMap = request;
	}

	@Override
	public String toString() {
		return "NewOrdderAction [date=" + date + ", ctmTable=" + ctmTable + ", resId=" + resId + ", ctmId=" + ctmId
				+ ", empId=" + empId + ", dhIds=" + dhIds + "]";
	}

	
	
	
}
