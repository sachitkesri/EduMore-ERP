<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="js/jquery.min.js"></script>
<script src="js/jquery.blockUI.js"></script>
<script>
	function addNewFollowUp(enquiryId){
		$.get("./EnquiryStatus?enquiryId=" +enquiryId,function(response){
			if(response === "open"){
				$.blockUI({
		        	message: '<form action="./Followup" method="POST"><input type="hidden" value="'+ enquiryId +'"name="enquiryId"><label> Date</label><input type="text" name="date"></input><br>	<label>Remarks</label><input type="text" name="remarks"></input><br><input type="checkbox" name="enquirystatus" value="close">Close This Enquiry<br><input type="radio" name="admissionstatus" checked="checked" value="hold">hold<br><input type="radio" name="admissionstatus" value="intereted">Interested<br><input type="radio" name="admissionstatus" value="notinterested">Not Interested<br><input type="submit"></input><input id="cancel" type="reset" value="close"></input></form>',
		        	overlayCSS : {
						opacity : 0.5 
					},
					css : {
						border : 'none',
						padding : '15px',
						'-webkit-border-radius' : '10px',
						'-moz-border-radius' : '10px',
						opacity : 1,
					}
				}); 
			    $("#cancel").click(function(){
			    	$.unblockUI();
				});
			}else if(response === "close"){
				$.blockUI({
		        	message: 'This enquiry has been closed. <a id="viewFollowup" href="javascript:viewFollowUp('+enquiryId+')">View Follow Up</a><br><input id="cancel" type="reset" value="close">',
		        	overlayCSS : {
						opacity : 0.5 
					},
					css : {
						border : 'none',
						padding : '15px',
						'-webkit-border-radius' : '10px',
						'-moz-border-radius' : '10px',
						opacity : 1,
					}
				}); 
				$("#cancel").click(function(){
					$.unblockUI();
				});
			}
		});
	};
	
	function viewFollowUp(enquiryId){
		$.getJSON("./ListFollowup?enquiryId=" +enquiryId, function(result) {
			var followupList = result.followupList;
			var displayFollowupList = '<tbody>'; 
			for(var key in followupList){
				displayFollowupList = displayFollowupList + "<tr>";
				$.each(followupList[key], function(objKey, objValue){
					displayFollowupList = displayFollowupList + "<td>"+objValue+"</td>";
				});
				displayFollowupList = displayFollowupList + "</tr>";
      		} 
			displayFollowupList = displayFollowupList + "</tbody>";
			
			$.blockUI({
	        		message: "<table><thead><tr><td><p>S.No</p></td><td><p>Date</p></td><td><p>Remarks</p></td></tr></thead>"+displayFollowupList+"</table><br><input id='cancel' type='reset' value='close'>"
	    	}); 
			$("#cancel").click(function(){
				$.unblockUI();
			});
		}, function(error) {
			console.log(error);
		});
		
	};
</script>
</head>
<body>
<label style="color:${follwupStatusMsgColor}">${follwupStatusMessage}</label>
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
             <td><input type="hidden" value="${element.enquiryNumber}" name="enquiryNumber"/>${element.enquiryNumber}</td>
             <td>${element.firstName}${element.lastName}</td>
             <td>${element.mobileNumber}</td> 

            <td><a href="./EditEnquiry?enquiryId=${element.enquiryNumber}">Edit</a><a id="addFollowup" href="javascript:addNewFollowUp(${element.enquiry_id})">Add Follow Up</a><a id="viewFollowup" href="javascript:viewFollowUp(${element.enquiry_id})">View Follow Up</a><a id="register" href="./regisration.jsp?enquiryNumber=${element.enquiryNumber}">Register</a></td>
        </tr> 
        <% i++; %>
    </c:forEach>
    </tbody>
   </table>
   </form>
</body>
</html>
