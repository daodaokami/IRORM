package com.iroiro.spring.hibernate.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iroiro.spring.hibernate.services.DishTestService;
import com.iroiro.spring.hibernate.services.RestaurantTestService;
import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ApplicationContext ctx = null;
	private DishTestService dts = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		dts = ctx.getBean(DishTestService.class);
	}
	private File ppt;
	private String pptContentType;
	private String pptFileName;
	
	private String pptDesc;
	
	public String getPptDesc() {
		return pptDesc;
	}
	public void setPptDesc(String pptDesc) {
		this.pptDesc = pptDesc;
	}
	public File getPpt() {
		return ppt;
	}
	public void setPpt(File ppt) {
		this.ppt = ppt;
	}
	public String getPptContentType() {
		return pptContentType;
	}
	public void setPptContentType(String pptContentType) {
		this.pptContentType = pptContentType;
	}
	public String getPptFileName() {
		return pptFileName;
	}
	public void setPptFileName(String pptFileName) {
		this.pptFileName = pptFileName;
	}
	@Override
	public String execute() throws Exception{
		System.out.println(ppt);
		System.out.println(pptContentType);
		System.out.println(pptFileName);
		System.out.println(pptDesc);
		
		ServletContext servletContext = ServletActionContext.getServletContext();
		String dir = servletContext.getRealPath("/files/"+pptFileName);
		
		System.out.println("dir:"+dir);
		
		FileOutputStream out = new FileOutputStream(dir);
		FileInputStream in = new FileInputStream(ppt);
		
		byte [] buffer = new byte[1024];
		int len = 0;
		
		while((len = in.read(buffer)) != -1){
			out.write(buffer, 0, len);
		}
		out.close();
		in.close();
		
		dts.updateDishImg(1, dir);
		return super.execute();
	}
}
