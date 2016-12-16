package com.iroiro.spring.hibernate.action;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iroiro.spring.hibernate.jsontools.JsonTools;
import com.iroiro.spring.hibernate.services.RestaurantTestService;
import com.opensymphony.xwork2.ActionContext;

public class RegisterRestaurantAction {
	private ApplicationContext ctx = null;
	private RestaurantTestService rts = null;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		rts = ctx.getBean(RestaurantTestService.class);
	}
	
	@SuppressWarnings("unchecked")
	public String execute(){
		//在配置文件中设置了一个叫做硅谷的参数
		//ActionContext是ACtion的上下文对象，可以从中获得当前Action需要的一切信息
		ActionContext actionContext = ActionContext.getContext();
		//3.request
		
		//4.获取请求参数对应的map	
		Map<String ,Object> parameters = actionContext.getParameters();
		String resName = ((String[])parameters.get("name"))[0];
		String resAddress = ((String[])parameters.get("address"))[0];
		String resTele = ((String[])parameters.get("phone"))[0];
		int flag = rts.saveNewRes(resName, resAddress, resTele);
		
		String msg = "";
		msg = JsonTools.createJsonString("status", flag);
		System.out.println(msg);
		Map<String, Object> requestMap = (Map<String, Object>) actionContext.get("request");
		requestMap.put("register", msg);
		return "success";
	}
}
