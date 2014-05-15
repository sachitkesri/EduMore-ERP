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
<form action="./EditEnquiry" method="GET">
<table>
<thead>
<tr>
<td>
<p>Name</p>
</td>

<td>
<p>PhoneNumber</p>
</td>
</tr>
</thead>
<tbody>
<c:forEach var="element" items="${list}">
        <tr>
        <td><input type="text" name="test" value="${element.enquiry_id}"></td>
            <td>${element.firstName}</td> 
             <td>${element.mobileNumber}</td> 
            <td><a href="./EditEnquiry?enquiryId=${element.enquiryNumber}">Edit</a></td>
        </tr> 
    </c:forEach>
    </tbody>
   </table>
   </form>
</body>
</html>