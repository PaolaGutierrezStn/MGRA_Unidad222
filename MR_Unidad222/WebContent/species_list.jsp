<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border= "1">
		<tr>
			
			<th>
			
				<form action="SpecieController">
				
					<input type = "submit" name = "btn_new" value = "New"/>
				</form>
			 </th>
			 <th>Id</th>
			 <th>Name</th>
			 <th>Genus</th>
			 <th>Species</th>
			  <th>Value</th>
			  
			
		</tr>
		
		<c:forEach var="specie" items="${species}">
		
		<tr>
			<td>
				<form action= "SpecieController">
					<input type = "hidden" name = "id" value= "${specie.id}">
					<input type = "submit" name= "btn_edit" value= "Edit" />
					<input type = "submit" name= "btn_delete" value= "Delete">
				</form>
			</td>
			<td> ${specie.id}</td>
			<td> ${specie.name}</td>
			<td> ${specie.genus}</td>
			<td> ${specie.species}</td>
			<td> ${specie.value}</td>
		</tr>
		
		</c:forEach>
		
	
	</table>


</body>
</html>