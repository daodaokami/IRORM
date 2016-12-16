<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>new ordder</title>
</head>
<body>
	<s:form action="newordder">
		<s:textfield name="ctmTable" label="tableNumber"></s:textfield>
		<s:textfield name="resId" label="Restaurant"></s:textfield>
		<s:textfield name="ctmId" label="Customer"></s:textfield>
		<s:textfield name="empId" label="Emplouee"></s:textfield>
		
		<s:checkboxlist list="#request.dishes"
			listKey="dhId" listValue="dhName"
			label="Dish" name="dishes"></s:checkboxlist>
		<s:submit></s:submit>
	</s:form>
</body>
</html>