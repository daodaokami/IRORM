package com.iroiro.spring.hibernate.action;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iroiro.spring.hibernate.jsontools.JsonTools;
import com.iroiro.spring.hibernate.services.DishTestService;
import com.iroiro.spring.hibernate.services.OrderTestService;
import com.iroiro.spring.hibernate.services.RestaurantTestService;
import com.opensymphony.xwork2.ActionContext;

public class DeleteItemsAction {
	private ApplicationContext ctx = null;
	private RestaurantTestService rts = null;
	private DishTestService dts = null;
	private OrderTestService ots = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		rts = ctx.getBean(RestaurantTestService.class);
		dts = ctx.getBean(DishTestService.class);
		ots = ctx.getBean(OrderTestService.class);
	}
	
	@SuppressWarnings("unchecked")
	public String execute(){
		System.out.println("删除操作");
		ActionContext actionContext = ActionContext.getContext();
		Map<String ,Object> parameters = actionContext.getParameters();
		String dhid = ((String[])parameters.get("dhId"))[0];
		Integer dhId = new Integer(dhid);
		//首先在database中查找一下，有没有这个菜的订单，如果有那么就把菜的状态置0，其他的不变，不真的删除,要查询所有的order，看里面是否有这个
		//要删除的订单的dhId
		//如果数据库报错了，那么肯定是有错的
		try{
			dts.deleteDish(dhId);
			System.out.println("删除成功");
			String msg = JsonTools.createJsonString("status", 1);
			Map<String, Object> requestMap = (Map<String, Object>)actionContext.get("request");
			requestMap.put("delete", msg);
		}catch(Exception e){
			dts.setDhState0(dhId);
			String msg = JsonTools.createJsonString("status", 0);
			Map<String, Object> requestMap = (Map<String, Object>) actionContext.get("request");
			requestMap.put("delete", msg);
		}
		return "success";
	}
}
