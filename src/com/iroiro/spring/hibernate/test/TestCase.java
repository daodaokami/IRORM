package com.iroiro.spring.hibernate.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iroiro.spring.hibernate.entities.Customer;
import com.iroiro.spring.hibernate.entities.Dish;
import com.iroiro.spring.hibernate.entities.Employee;
import com.iroiro.spring.hibernate.entities.Material;
import com.iroiro.spring.hibernate.entities.Restaurant;
import com.iroiro.spring.hibernate.entities.Style;
import com.iroiro.spring.hibernate.services.CustomerTestService;
import com.iroiro.spring.hibernate.services.DishTestService;
import com.iroiro.spring.hibernate.services.EmployeeTestService;
import com.iroiro.spring.hibernate.services.MaterialTestService;
import com.iroiro.spring.hibernate.services.OrderTestService;
import com.iroiro.spring.hibernate.services.RestaurantTestService;
import com.iroiro.spring.hibernate.services.StyleTestService;


public class TestCase {

	private ApplicationContext ctx = null;
	private RestaurantTestService rts = null;
	private CustomerTestService cts = null;
	private EmployeeTestService ets = null;
	private DishTestService dts = null;
	private MaterialTestService mts = null;
	private OrderTestService ots = null;
	private StyleTestService sts = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		rts = ctx.getBean(RestaurantTestService.class);
		cts = ctx.getBean(CustomerTestService.class);
		ets = ctx.getBean(EmployeeTestService.class);
		dts = ctx.getBean(DishTestService.class);
		mts = ctx.getBean(MaterialTestService.class);
		ots = ctx.getBean(OrderTestService.class);
		sts = ctx.getBean(StyleTestService.class);
	}
	

	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}
	
	@Test
	public void testRTS(){
		//rts.showResInfo(1);
		//rts.showResStyleInfo(1);
		//rts.showAllEmpInRes(1);
		//rts.showAllRes();
		//rts.saveNewRes("难吃园", "bjts001", "1001");
		//rts.saveNewRes("丁香园", "bjts002", "1002");
		//rts.saveNewRes("听涛园", "bjts003", "1003");
		//rts.saveNewRes("紫荆园", "bjts004", "1004");
		/**
		 * 可能是后面的order的连级出了问题*/
		//rts.deleteOldRes(3);//这里有点问题，之后进行修改
		
		//rts.updateResInfo(3, "听涛园", "bjts003", "1003");
		//rts.updateResStyle(1, 3, false, true, true);
		
		/*List<Restaurant> ress = rts.returnRess();
		for(Restaurant res:ress){
			System.out.println(res.getResName()+", "+res.getResTele());
		}
		*/
		//Restaurant res = rts.returnRes(1);
		//System.out.println(res);
	}
	
	@Test 
	public void testCTS(){
		//cts.ShowCtmInfo(1);
		//cts.saveNewCtm("茜");
		//cts.deleteOldCtm(3);//这里通过ctm连级删除order是没有问题的
		//cts.dishShopService(1, 1, 1,new Date(),1);
		System.out.println(cts.returnCustomer(1));
		List<Customer> ctms = cts.returnCustomers(1);
		System.out.println(ctms.size());
		for(Customer ctm:ctms){
			System.out.println(ctm);
		}
	}
	
	@Test
	public void testETS(){
		//ets.showEmpInfo(1);
		/*ets.addEmpToRes("daodao", "1010", 1);
		ets.addEmpToRes("qian","1011",2);
		ets.addEmpToRes("lu", "1012", 3);
		ets.addEmpToRes("qianq", "1013", 4);
		ets.addEmpToRes("he", "1015", 5);*/
		//ets.deleteOldEmp(4);
		//ets.updateSalary(1, 2000);
		//ets.updateEmpPosiandLeader(1, 2, 2);
		
		System.out.println("emp："+ets.returnEmp(1));
		
		List<Employee> emps0 = ets.returnEmps(3);
		for(Employee emp:emps0){
			System.out.println("空emps："+emp);
		}		
		List<Employee> emps = ets.returnEmps();
		for(Employee emp:emps){
			System.out.println(emp);
		}
	}
	
	@Test
	public void testDTS(){//材料这里就完成了
		String expro = "";
		//假设现在从前端传输来了一个json的字符串，或者仅仅是一些字符对（a:b）这样子的
		dts.setExPro(1, expro);
		
		System.out.println(dts.getExPro(1));
		/*Dish dh = new Dish("排骨饭", 25);
		Restaurant res = rts.returnRes(1);
		dh.setRestaurant(res);
		Set<Material> mrls = new HashSet<Material>();
		Material mrl1 = new Material("排骨");
		Material mrl2 = new Material("米饭");
		mts.addMaterial(1, mrl1);
		mts.addMaterial(1, mrl2);
	//	mrl1 = mts.returnMrl("排骨");
	//	mrl2 = mts.returnMrl("米饭");
		
		mrls.add(mrl1);
		mrls.add(mrl2);
		
		dh.setMaterials(mrls);
		dts.addNewDish(dh);*/
		//dts.showDishInfo(1);
		//dts.showMaterialofDish(1);
		/*dts.addNewDish(1,"拍黄瓜", 16);
		dts.addNewDish(1, "红烧肉", 25);
		dts.addNewDish(1, "烤腊肠", 5);
		dts.addNewDish(1, "照烧鸡腿", 10);
		dts.addNewDish(2, "酱茄子", 16);
		dts.addNewDish(2, "东坡肉", 40);
		dts.addNewDish(2, "手抓羊肉", 32);
		dts.addNewDish(3, "蒜香牛肉", 60);
		dts.addNewDish(3, "烧皮肉", 34);
		dts.addNewDish(3, "蒜香肠", 10);*/
		/*List<Integer> mrlIds = new ArrayList<>();
		mrlIds.add(1);
		mrlIds.add(9);
		dts.buildRela(1, mrlIds);
		
		List<Integer> mrlIds1 = new ArrayList<>();
		mrlIds1.add(4);
		mrlIds1.add(1);
		dts.buildRela(2, mrlIds1);
		
		List<Integer> mrlIds2 = new ArrayList<>();
		mrlIds2.add(3);
		mrlIds2.add(2);
		dts.buildRela(4, mrlIds2);
		
		List<Integer> mrlIds3 = new ArrayList<>();
		mrlIds3.add(5);
		mrlIds3.add(6);
		dts.buildRela(5, mrlIds3);*/
		//在菜和材料之间设置关联表，多对多，删除菜的时候并不删除材料，只删除关联表
		/*Dish dh = dts.returnDish(1);
		System.out.println(dh);
		List<Dish> dhes1 = dts.returnDishes(1);
		System.out.println(dhes1.size());
		
		List<Dish> dhes2 = dts.returnDishes();
		System.out.println(dhes2.size());*/
		//dts.deleteDish(1);//这里面的dh_mrl没有问题，但是order_dh有关联，所以也不可以删,
		//这里面已经解决了dish可以删除，并且更新与材料对应关系！
		
		/*Set<Material> mrls = dts.returnMrls(1);
		System.out.println(mrls);*/
	}
	
	@Test
	public void testMTS(){
		//mts.showMaterialInfo(1);
		/*mts.addMaterial(1, "香肠", 10, 30);
		mts.addMaterial(1, "黄瓜", 2, 40);
		mts.addMaterial(1, "鸡肉", 16, 60);
		mts.addMaterial(1, "五花肉", 20, 70);
		
		mts.addMaterial(2, "茄子", 3, 30);
		mts.addMaterial(2, "萝卜", 2, 40);
		mts.addMaterial(2, "羊肉", 27, 60);
		mts.addMaterial(2, "五花肉", 20, 70);
		
		mts.addMaterial(3, "香肠", 10, 30);
		mts.addMaterial(3, "大蒜", 7, 30);
		mts.addMaterial(3, "牛肉", 30, 100);
		mts.addMaterial(3, "五花肉", 20, 70);*/
	/*	Material mrl = mts.returnMrl(1);
		List<Material> mrls = mts.returnMrls();
		System.out.println(mrl);
		for(Material mrl1:mrls){
			System.out.println(mrl1);
		}*/
	/*List<Material> mrls = mts.returnMrls(1);
		for(Material mrl:mrls){
			System.out.println(mrl);
		}*/
		
		//mts.showAllMrl();
		//mts.showAllMrlByRes(1);
		//mts.addMaterial(1, "黄瓜");
		//mts.updateMaterialAmount(1, 10);
		//System.out.println(mts.returnMrl("xiangchang"));
	}
	
	@Test
	public void testOTS(){
		
		//ots.showOrderInfo(2);
		//ots.showAllOrder();
		//ots.showOrderPrice(4);
		/*Set<Integer>dhIds = new HashSet();
		dhIds.add(1);
		dhIds.add(2);*/
		
		/*System.out.println("order:"+ots.returnOrder(1));
		System.out.println("orders in res1:"+ots.returnOrders(1));
		System.out.println("orders:"+ots.returnOrders());*/
		
		/*Integer price = ots.returnOrderPrice(1);
		System.out.println(price);*/
	}
	
	@Test
	public void testSTS(){
		/*Style sty = sts.returnStyle(1);
		System.out.println(sty);*/
		sts.updateStyle(1, 10, false, false, true);
	}
	
	
	
}
