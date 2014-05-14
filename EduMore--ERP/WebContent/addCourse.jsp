<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./AddCourse" method="post">
<label>Course Title</label>
<input type="text" name="courseTitle"></input><br>
<label>Duration</label>
<input type="text" name="duration"></input>
<label>(In months)</label>
<input type="submit"></input>

${status}
</form>
</body>
</html>