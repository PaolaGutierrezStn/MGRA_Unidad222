<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border= "1">
		<tr>
			
			<th>
			
				<form action="TreeContoller">
				
					<input type = "submit" name = "btn_new" value = "New"/>
				</form>
			 </th>
			 <th>Id</th>
			 <th>Name</th>
			 <th>Type</th>
			 <th>Height</th>
			  <th>Locations</th>
			  <th>Units</th>
			  
			
		</tr>
		
		<c:forEach var="tree" items="${trees}">
		
		<tr>
			<td>
				<form action= "TreeContoller">
					<input type = "hidden" name = "id" value= "${tree.id}">
					<input type = "submit" name= "btn_edit" value= "Edit" />
					<input type = "submit" name= "btn_delete" value= "Delete">
				</form>
			</td>
			<td> ${tree.id}</td>
			<td> ${tree.name}</td>
			<td> ${tree.type}</td>
			<td> ${tree.height}</td>
			<td> ${tree.locations}</td>
			<td> ${tree.units}</td>
		</tr>
		
		</c:forEach>
		
	
	</table>

</body>
</html>