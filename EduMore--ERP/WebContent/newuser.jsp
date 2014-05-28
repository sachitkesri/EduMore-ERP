<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./UserProfile" method="POST">
<input type="hidden" value="addNewUser" name="action"/>
<label>Name</label>
<input type="text" name="name" value=""/><br>
<label>Role</label>
<input type="text" name="role" value=""/><br>
<label>E-mail</label>
<input type="text" name="email" value=""/><br>
<label>Contact Number</label>
<input type="text" name="contactNumber" value=""/><br>

<label>Date of joining</label>
<input type="text" name="dateOfJoining" value=""/><label>(MM/DD/YYYY)</label><br>
<label>Address</label>
<textarea name="address"></textarea><br>

<label>Username</label>
<input type="text" name="username" value=""/><br>
<label>Password</label>
<input type="text" name="password" value=""/><br>
<input type="submit" value="Add User" >
</form>
<label color="${userAdditionStatusMsgColor}">${userAdditionStatusMsgColor}</label>
</body>
</html>