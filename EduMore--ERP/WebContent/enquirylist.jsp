<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="js/jquery.blockUI.js"></script>
<script>
	function addNewFollowUp(enquiryId){
		$.blockUI({
	        	message: '<form action="./Followup" method="POST"><input type="hidden" value="'+ enquiryId +'"name="enquiryId"><label> Date</label><input type="text" name="date"></input><br>	<label>Remarks</label><input type="text" name="remarks"></input><br><input type="submit"></input><input id="cancel" type="reset" value="cancel"></input></form>'
	    }); 
	    $("#cancel").click(function(){
	    	$.unblockUI();
		});
	    
	};
	
	function viewFollowUp(enquiryId){
		$.ajax({
			url: "./ListFollowup?enquiryId=" +enquiryId,
           	type: "GET",
            processData: false,
          	contentType :false,
          	success: function (resp) {
          		console.log(resp);
          		var followupList = resp['followupList'];
          		for(var key in followupList){
          			console.log(key);
          		} 
          		$.blockUI({
    	        	message: "<table><thead><tr><td><p>S.No</p></td><td><p>Date</p></td><td><p>Remarks</p></td></tr></thead><tbody><% int j=1; %><c:forEach var='element' items='${followuplist}'><tr><td><%=j %> </td> <td>${element.firstName}</td><td>${element.date}</td><td>${element.remarks}</td> <td><a href='./EditEnquiry?enquiryId=${element.enquiryId}'>Edit</a></td></tr> <% j++; %></c:forEach></tbody></table>"
    	    }); 
    	    $("#cancel").click(function(){
    	    	$.unblockUI();
    		});
          	}
		});
		
	};
</script>
</head>
<body>
<form action="./EditEnquiry" method="GET">
<table>
<thead>
<tr>
<td>
<p>S.No</p>
</td>
<td>
<p>Enquiry Number</p>
</td>
<td>
<p>Name</p>
</td>
<td>
<p>PhoneNumber</p>
</td>

</tr>
</thead>
<tbody><% int i=1; %>
<c:forEach var="element" items="${list}">
        <tr>
        	<td><%=i %> </td> 
             <td>${element.enquiryNumber}</td>
             <td>${element.firstName}${element.lastName}</td>
             <td>${element.mobileNumber}</td> 

            <td><a href="./EditEnquiry?enquiryId=${element.enquiryNumber}">Edit</a><a id="addFollowup" href="javascript:addNewFollowUp(${element.enquiry_id})">Add Follow Up</a><a id="viewFollowup" href="javascript:viewFollowUp(${element.enquiry_id})">View Follow Up</a></td>
        </tr> 
        <% i++; %>
    </c:forEach>
    </tbody>
   </table>
   </form>
</body>
</html>
