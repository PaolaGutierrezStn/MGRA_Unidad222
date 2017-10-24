<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="SpecieController">
		<label>Common Name:</label><br>
		<input type = "text" name= "name" value = "${specie.name}" /><br>
		
		<label>Genus:</label><br>
		<input type = "text" name= "genus" value = "${specie.genus}" /><br>
		
		<label>Species:</label><br>
		<input type = "text" name= "species" value = "${specie.species}" /><br>
		
		<label>Left value:</label><br>
		<input type = "text" name= "value" value = "${specie.value}" /><br>
		
		<input type = "submit" name = "btn_save" id="btn_save" value = "Save"/>
	</form>
</body>
</html>