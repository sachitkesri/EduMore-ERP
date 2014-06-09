<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./register" method="post">
<label>Enquiry Number</label>
<input type="text" name="enquiryNumber" value="<%= request.getParameter("enquiryNumber") %>"><br>

<label>Amount Payble(in Rs)</label>
<input type="text" name="amount">
<br>
<label>E-mail</label>
<input type="text" name="email">
<br>
<input type="submit" value="Register">



</form>
<label style="color:${registrationStatusMsgColor}">${registrationStatusMessage}</label>
</body>
</html>