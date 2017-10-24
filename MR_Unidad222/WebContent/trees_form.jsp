<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="TreeContoller">
		<label>Name:</label><br>
		<input type = "text" name= "name" value = "${tree.name}" /><br>
		
		<label>Type:</label><br>
		<input type = "text" name= "type" value = "${tree.type}" /><br>
		
		<label>Eight:</label><br>
		<input type = "text" name= "height" value = "${tree.height}" /><br>
		
		<label>Locations:</label><br>
		<input type = "text" name= "locations" value = "${tree.locations}" /><br>
		
		<label>Units:</label><br>
		<input type = "text" name= "units" value = "${tree.units}" /><br>
		
		<input type = "submit" name = "btn_save" id="btn_save" value = "Save"/>
	</form>
</body>
</html>