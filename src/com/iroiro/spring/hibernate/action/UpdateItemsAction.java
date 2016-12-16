package com.iroiro.spring.hibernate.action;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iroiro.spring.hibernate.entities.Material;
import com.iroiro.spring.hibernate.jsontools.JsonTools;
import com.iroiro.spring.hibernate.services.DishTestService;
import com.iroiro.spring.hibernate.services.EmployeeTestService;
import com.iroiro.spring.hibernate.services.MaterialTestService;
import com.iroiro.spring.hibernate.services.OrderTestService;
import com.iroiro.spring.hibernate.services.RestaurantTestService;
import com.iroiro.spring.hibernate.services.StyleTestService;
import com.opensymphony.xwork2.ActionContext;

public class UpdateItemsAction {
	private ApplicationContext ctx = null;
	private RestaurantTestService rts = null;
	private DishTestService dts = null;
	private EmployeeTestService ets = null;
	private MaterialTestService mts = null;
	private StyleTestService sts = null;
	private OrderTestService ots = null;
	
	//update数据，也是通过http协议，修改一个名字，修改一个价格，通过传入的url的id来确定
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		rts = ctx.getBean(RestaurantTestService.class);
		dts = ctx.getBean(DishTestService.class);
		ets = ctx.getBean(EmployeeTestService.class);
		mts = ctx.getBean(MaterialTestService.class);
		sts = ctx.getBean(StyleTestService.class);
		ots = ctx.getBean(OrderTestService.class);
	}
	/*
	 * update接口11/14来实现
	 * 通过什么来获得数据呢？？
	 * 
	 * */
	
	//update也是一样的，只用找一个更新就好
	
	@SuppressWarnings("unchecked")
	public String execute(){
		ActionContext actionContext = ActionContext.getContext();
		Map<String ,Object> parameters = actionContext.getParameters();
		String type = ((String[])parameters.get("type"))[0];
		String msg = JsonTools.createJsonString("status", 0);
		if(type.equals("res")){
			String resid = ((String[])parameters.get("resId"))[0];
			Integer resId = new Integer(resid);
			String newName = ((String[])parameters.get("newName"))[0];
			
			try{
				rts.updateResInfo(resId, newName);
				msg = JsonTools.createJsonString("status", 1);
			}
			catch(Exception e){ 
				msg = JsonTools.createJsonString("status", 0);
			}
			//餐馆可修改的只有店名，电话
		}
		else if(type.equals("emp")){
			
			//员工可修改的只有工资
			String empid = ((String[])parameters.get("empId"))[0];
			String newsalary = ((String[])parameters.get("newSalary"))[0];
			Integer empId = new Integer(empid);
			int newSalary = new Integer(newsalary);
			try{
				ets.updateEmpSalary(empId, newSalary);
				msg = JsonTools.createJsonString("status", 1);
			}
			catch(Exception e){ 
				msg = JsonTools.createJsonString("status", 0);
			}
		
		}
		else if(type.equals("dish")){
			//菜可修改的只有价格
			String dhid = ((String[])parameters.get("dhId"))[0];
			String newprice = ((String[])parameters.get("newprice"))[0];
			Integer dhId = new Integer(dhid);
			int newPrice = new Integer(newprice);
			try{
				dts.updateDishPrice(dhId, newPrice);
				msg = JsonTools.createJsonString("status", 1);
			}
			catch(Exception e){ 
				msg = JsonTools.createJsonString("status", 0);
			}
			
		}
		else if(type.equals("style")){
			String resid = ((String[])parameters.get("resId"))[0];
			String color = ((String[])parameters.get("color"))[0];
			String hastime = ((String[])parameters.get("hast"))[0];
			String hasordermanager = ((String[])parameters.get("hasodm"))[0];
			String hasspecial = ((String[])parameters.get("hassp"))[0];
			System.out.println("color:"+color+", hasTime:"+hastime+", hasOrdderManager:"+hasordermanager+", hasSpecial:"+hasspecial);
			//sts.updateStyle(1, 20, true, true, true);
			Integer resId = new Integer(resid);
			Integer ccolor = new Integer(color); 
			boolean hasTime = new Boolean(hastime);
			boolean hasOrderManager = new Boolean(hasordermanager);
			boolean hasSpecial = new Boolean(hasspecial);
			
			try{
				sts.updateStyle(resId,ccolor,hasTime,hasOrderManager,hasSpecial);
				msg = JsonTools.createJsonString("status", 1);
			}catch(Exception e){
				msg = JsonTools.createJsonString("status", 0);
			}
			Map<String, Object> requestMap = (Map<String, Object>) actionContext.get("request");
			requestMap.put("update", msg);
			//风格三个都可修改
		}
		else if(type.equals("mrl")){
			//材料可修改的是数量
			String mrlid = ((String[])parameters.get("mrlId"))[0];
			String amount = ((String[])parameters.get("amount"))[0];
			Integer mrlId = new Integer(mrlid);
			Integer Amount = new Integer(amount);
			try{
				mts.updateMaterialAmount2(mrlId, Amount);
				msg = JsonTools.createJsonString("status", 1);
			}catch(Exception e){
				msg = JsonTools.createJsonString("status", 0);
			}
			
		}
		else{
			return "failed";
		}
		Map<String, Object> requestMap = (Map<String, Object>) actionContext.get("request");
		requestMap.put("update", msg);
		return "success";
	}
}
