package com.iroiro.spring.hibernate.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iroiro.spring.hibernate.jsontools.JsonTools;
import com.iroiro.spring.hibernate.services.DishTestService;
import com.iroiro.spring.hibernate.services.MaterialTestService;
import com.iroiro.spring.hibernate.services.RestaurantTestService;
import com.opensymphony.xwork2.ActionContext;

public class ManagerExPropertiesAction {
	private ApplicationContext ctx = null;
	private RestaurantTestService rts = null;
	private MaterialTestService mts = null;
	private DishTestService dts = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		rts = ctx.getBean(RestaurantTestService.class);
		mts = ctx.getBean(MaterialTestService.class);
		dts = ctx.getBean(DishTestService.class);
	}
	
	@SuppressWarnings("unchecked")
	public String execute(){
		//在配置文件中设置了一个叫做硅谷的参数
		//ActionContext是ACtion的上下文对象，可以从中获得当前Action需要的一切信息
		ActionContext actionContext = ActionContext.getContext();
		//3.request
		Map<String ,Object> parameters = actionContext.getParameters();
		String type = ((String[])parameters.get("type"))[0];
		String exPro = ((String[])parameters.get("expro"))[0];
		System.out.println("expro"+exPro);
		String str[] = exPro.split(" ");
		Map<String,String> exproMap = new HashMap<String, String>();
		for(int i=0;i<str.length;i++){
			String sstr[] = str[i].split(":");
			exproMap.put(sstr[0], sstr[1]);
		}
		String msg = JsonTools.createJsonString("exPro", exproMap);
		System.out.println(msg);
		Map<String, Object> requestMap = (Map<String, Object>) actionContext.get("request");
		requestMap.put("expro", msg);
		dts.setExPro(1, msg);
		return "success";
	}//存与写都在上面了
	
	
}
