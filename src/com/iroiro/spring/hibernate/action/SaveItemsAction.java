package com.iroiro.spring.hibernate.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iroiro.spring.hibernate.entities.Dish;
import com.iroiro.spring.hibernate.entities.Material;
import com.iroiro.spring.hibernate.entities.Ordder;
import com.iroiro.spring.hibernate.jsontools.JsonTools;
import com.iroiro.spring.hibernate.services.DishTestService;
import com.iroiro.spring.hibernate.services.EmployeeTestService;
import com.iroiro.spring.hibernate.services.MaterialTestService;
import com.iroiro.spring.hibernate.services.OrderTestService;
import com.iroiro.spring.hibernate.services.RestaurantTestService;
import com.opensymphony.xwork2.ActionContext;

public class SaveItemsAction {
	private ApplicationContext ctx = null;
	private RestaurantTestService rts = null;
	private DishTestService dts = null;
	private MaterialTestService mts = null;
	private EmployeeTestService ets = null;
	private OrderTestService ots = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		rts = ctx.getBean(RestaurantTestService.class);
		dts = ctx.getBean(DishTestService.class);
		mts = ctx.getBean(MaterialTestService.class);
		ets = ctx.getBean(EmployeeTestService.class);
		ots = ctx.getBean(OrderTestService.class);
	}
	//给出一个接口，提供输入的信息的一个表单，填了表单，就可以将数据插入数据库中，其实这个功能和插入restaurant的功能是一样的，所以可以不实现
	//主要要实现一个订单的接口，当用户要下单的时候，点击下单，就弹出一个接口网页，然后将里面选择了的菜什么的打包，组装进去，形成一个order，然后存储起来
	
	@SuppressWarnings("unchecked")
	public String execute(){
		ActionContext actionContext = ActionContext.getContext();
		Map<String ,Object> parameters = actionContext.getParameters();
		String type = ((String[])parameters.get("type"))[0];
		String resid = ((String[])parameters.get("resId"))[0];
		Integer resId = new Integer(resid);
		String msg = JsonTools.createJsonString("status", 0);
		if(type.equals("menu")){
			//在菜单维护的时候，插入数据，获得dhName,dhPrice,dhMrlList
			String dhName = ((String[])parameters.get("dhName"))[0];
			String dhprice = ((String[])parameters.get("dhPrice"))[0];
			int dhPrice = new Integer(dhprice);
			String dhMrlList = ((String[])parameters.get("dhMrlList"))[0];
			Set<Material> mrls = new HashSet<Material>();
			Dish dh = new Dish(dhName,dhPrice);//首先dish创建了一个实例
			dh.setRestaurant(rts.returnRes(resId));
			int start=0,end=0;
			int k=0;
			char ck = ' ';
			String mrlName = "";
			System.out.println("菜名:"+dhName);
			System.out.println("材料List:"+dhMrlList);
			String str[] = dhMrlList.split(" ");
			System.out.println(str.length);
			//在str里面存储了所有材料的名字
			System.out.println("check = "+dts.checkMs(resId, dhName));//check为false
			if(!dts.checkMs(resId, dhName)){
				//如果不存在当前这个新的菜色，那么先检查是否有材料，没有材料则
				for(int i=0;i<str.length;i++){
					Material mrl = mts.returnMrl(resId,str[i]);
					if(mrl == null){
						mrl = new Material(str[i]);
						mts.addMaterial(resId, mrl);
					}
					mrl = mts.returnMrl(resId, str[i]);
					mrls.add(mrl);
				}
				dh.setMaterials(mrls);
				dh.setDhState(0);
				dts.addNewDish(dh);
				msg = JsonTools.createJsonString("status", 1);
			}
			else{
				//有这个菜，那么就报一个异常，然后处理msg
				msg = JsonTools.createJsonString("status", 0);
			}
			Map<String, Object> requestMap = (Map<String, Object>) actionContext.get("request");
			requestMap.put("save", msg);
		}else if(type.equals("mrl")){
			
		}else if(type.equals("order")){
			try{
				Ordder ordder = new Ordder();
			
				ordder.setRestaurant(rts.returnRes(resId));
				ordder.setDate(new Date());
				
				String ctmtable = ((String[])parameters.get("ctmTable"))[0];
				String empid = ((String[])parameters.get("empId"))[0];
				Integer ctmTable = new Integer(ctmtable);
				Integer empId = new Integer(empid);
				ordder.setEmployee(ets.returnEmp(empId));
				ordder.setCtmTable(ctmTable);
				String dhlist = ((String[])parameters.get("dhList"))[0];
				String str[] = dhlist.split(" ");
				List<Integer> idItem = new ArrayList<Integer>();
				for(int i=0;i<str.length;i++){
					idItem.add(new Integer(str[i]));
				}
				//已经获得了正常的ordder的时间，桌号，餐馆，员工，然后就是dh了，这里的dh，只需要获得dh相应的dhId就比较方便了
				Set<Dish> dhes = new HashSet<Dish>();
				for(int i=0;i<idItem.size();i++){
					Dish dh = new Dish();
					dh = dts.returnDish(idItem.get(i));
					dhes.add(dh);
				}
				
				System.out.println(dhes);
				ordder.setDishes(dhes);
				ots.saveOrdder(ordder);
				msg = JsonTools.createJsonString("status", 1);
				Map<String, Object> requestMap = (Map<String, Object>) actionContext.get("request");
				requestMap.put("save", msg);
			}catch(Exception e ){
				msg = JsonTools.createJsonString("status", 0);
				Map<String, Object> requestMap = (Map<String, Object>) actionContext.get("request");
				requestMap.put("save", msg);
			}
		}
		return "success";
	}
}
