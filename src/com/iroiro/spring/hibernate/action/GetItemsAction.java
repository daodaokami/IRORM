package com.iroiro.spring.hibernate.action;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.ws.Response;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iroiro.spring.hibernate.entities.Customer;
import com.iroiro.spring.hibernate.entities.Dish;
import com.iroiro.spring.hibernate.entities.Employee;
import com.iroiro.spring.hibernate.entities.Material;
import com.iroiro.spring.hibernate.entities.Ordder;
import com.iroiro.spring.hibernate.entities.Restaurant;
import com.iroiro.spring.hibernate.entities.Style;
import com.iroiro.spring.hibernate.jsontools.JsonTools;
import com.iroiro.spring.hibernate.services.CustomerTestService;
import com.iroiro.spring.hibernate.services.DishTestService;
import com.iroiro.spring.hibernate.services.EmployeeTestService;
import com.iroiro.spring.hibernate.services.MaterialTestService;
import com.iroiro.spring.hibernate.services.OrderTestService;
import com.iroiro.spring.hibernate.services.RestaurantTestService;
import com.iroiro.spring.hibernate.services.StyleTestService;
import com.opensymphony.xwork2.ActionContext;

public class GetItemsAction {
	
	private ApplicationContext ctx = null;
	private RestaurantTestService rts = null;
	private StyleTestService sts = null;
	private EmployeeTestService ets = null;
	private DishTestService dts = null;
	private MaterialTestService mts = null;
	private OrderTestService ots = null;
	private CustomerTestService cts = null;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		rts = ctx.getBean(RestaurantTestService.class);
		sts = ctx.getBean(StyleTestService.class);
		ets = ctx.getBean(EmployeeTestService.class);
		dts = ctx.getBean(DishTestService.class);
		mts = ctx.getBean(MaterialTestService.class);
		ots = ctx.getBean(OrderTestService.class);
		cts = ctx.getBean(CustomerTestService.class);
	}
	
	@SuppressWarnings("unchecked")
	public String execute(){
		ActionContext actionContext = ActionContext.getContext();
		//3.request
		
		//4.获取请求参数对应的map	
		Map<String ,Object> parameters = actionContext.getParameters();
		String type = ((String[])parameters.get("type"))[0];
		String resid = ((String[])parameters.get("resId"))[0];
		String id = ((String[])parameters.get("id"))[0];
		Integer resId = new Integer(resid);
		Integer Id = new Integer(id);
		String msg = "";
		if(type.equals("res")){//这里有设置res风格功能，
			//这里面通过resId找到该餐馆的style	
			Restaurant res = rts.returnRes(resId);	
			//首先发一个信息上去，再响应发挥来的信息
			if(res != null){
				Style style = sts.returnStyle(resId);
				msg = JsonTools.createJsonString("style", style);
			}
			else{
				msg = JsonTools.createJsonString("status", 0);
			}
			Map<String, Object> requestMap = (Map<String, Object>) actionContext.get("request");
			requestMap.put("descs", msg);
			
		}
		else if(type.equals("emp")){
			Restaurant res = rts.returnRes(resId);
			if(res != null){
				if(Id != 0 ){
					System.out.println("Id="+Id);
					Employee emp = ets.returnEmp(Id);
					if(emp != null){
						msg = JsonTools.createJsonString("emp", emp);
					}
					else{
						msg = JsonTools.createJsonString("status", 0);
					}
				}
				else{
					//Id为0，按照res来搜索整个餐馆的员工
					List<Employee> emps = ets.returnEmps(resId);
					if(emps != null){
						msg = JsonTools.createJsonString("emps", emps);
					}
					else{
						msg = JsonTools.createJsonString("status", 0);
					}
				}
			}
			else{
				msg = JsonTools.createJsonString("status", 0);
			}
			Map<String, Object> requestMap = (Map<String, Object>) actionContext.get("request");
			requestMap.put("descs", msg);
		}
		else if(type.equals("dish")){
			Restaurant res = rts.returnRes(resId);
			if(res != null){
				if(Id != 0 ){
					System.out.println("Id="+Id);
					Dish dh = dts.returnDish(Id);
					Integer dhId = dh.getDhId();
					dh.setMaterials(dts.returnMrls(dhId));
					List<Dish> dhes = new ArrayList<Dish>();
					dhes.add(dh);
					if(dh != null){
						msg = JsonTools.createJsonString("dishes", dhes);
					}
					else{
						msg = JsonTools.createJsonString("status", 0);
					}
				}
				else{
					//Id为0，按照res来搜索整个餐馆的员工
					List<Dish> dhes = dts.returnDishes(resId);
					for(int i=0;i<dhes.size();i++){
						Integer dhId = dhes.get(i).getDhId();
						dhes.get(i).setMaterials(dts.returnMrls(dhId));
					}
					if(dhes != null){
						msg = JsonTools.createJsonString("dishes", dhes);
					}
					else{
						msg = JsonTools.createJsonString("status", 0);
					}
				}
			}
			else{
				msg = JsonTools.createJsonString("status", 0);
			}
			System.out.println(msg);
			Map<String, Object> requestMap = (Map<String, Object>) actionContext.get("request");
			//request().attribute("dao", "哈哈哈");
			requestMap.put("descs", msg);
		}
		else if(type.equals("mrl")){
			Restaurant res = rts.returnRes(resId);
			if(res != null){
				if(Id != 0 ){
					System.out.println("Id="+Id);
					Material mrl = mts.returnMrl(Id);
					if(mrl != null){
						msg = JsonTools.createJsonString("material", mrl);
					}
					else{
						msg = JsonTools.createJsonString("status", 0);
					}
				}
				else{
					//Id为0，按照res来搜索整个餐馆的员工
					List<Material> mrls = mts.returnMrls(resId);
					if(mrls != null){
						msg = JsonTools.createJsonString("materials", mrls);
					}
					else{
						msg = JsonTools.createJsonString("status", 0);
					}
				}
			}
			else{
				msg = JsonTools.createJsonString("status", 0);
			}
			Map<String, Object> requestMap = (Map<String, Object>) actionContext.get("request");
			requestMap.put("descs", msg);
		}
		else if(type.equals("order")){
			Restaurant res = rts.returnRes(resId);
			if(res != null){
				if(Id != 0 ){
					Ordder ordder = ots.returnOrder(Id);
					if(ordder != null){
						System.out.println("test");
						msg = JsonTools.createJsonString("ordder", ordder);
						System.out.println("test");
					}
					else{
						msg = JsonTools.createJsonString("status", 0);
					}
				}
				else{
					//Id为0，按照res来搜索整个餐馆的员工
					List<Ordder> ordders = ots.returnOrders(resId);
					if(ordders != null){
						msg = JsonTools.createJsonString("ordders", ordders);
					}
					else{
						msg = JsonTools.createJsonString("status", 0);
					}
				}
			}
			else{
				msg = JsonTools.createJsonString("status", 0);
			}
			Map<String, Object> requestMap = (Map<String, Object>) actionContext.get("request");
			requestMap.put("descs", msg);
		}
		/*
		 * 
		 * customer的方式是一个难点
		 * 
		 * */
		else if(type.equals("ctm")){
			Restaurant res = rts.returnRes(resId);
			if(res != null){
				if(Id != 0 ){//id就是客人id
					Customer ctm = cts.returnCustomer(Id);
					if(ctm != null){
						msg = JsonTools.createJsonString("ctm", ctm);
					}
					else{
						msg = JsonTools.createJsonString("status", 0);
					}
				}
				else{
					//id==0则通过resId获得，该餐厅的顾客用餐情况
					List<Customer> ctms = cts.returnCustomers(resId);
					if(ctms != null){
						msg = JsonTools.createJsonString("ctms", ctms);
					}
					else{
						msg = JsonTools.createJsonString("status", 0);
					}
				}
			}
			else{
				msg = JsonTools.createJsonString("status", 0);
			}
			Map<String, Object> requestMap = (Map<String, Object>) actionContext.get("request");
			requestMap.put("descs", msg);
		}
		else if(type.equals("style")){
			//唯有通过resId来返回一个style，并可以通过update接口修改
			Restaurant res = rts.returnRes(resId);
			if(res != null){
				Style style = sts.returnStyle(resId);
				//res不为null，那么style就不会是null
				msg = JsonTools.createJsonString("style", style);
			}
			else
				msg = JsonTools.createJsonString("status", 0);
			Map<String, Object> requestMap = (Map<String, Object>) actionContext.get("request");
			requestMap.put("descs", msg);
		}
		else{
			return "failed";
		}
		return "success";
	}
}
