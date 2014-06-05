<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="js/jquery.min.js"></script>
<script>
	function initAdmissionNotifications(){
		setTimeout(function(){
			$.getJSON("./loadPendingAdmission", function(response){
				var registeredEnquiryNumbers = response.enquiryNumbersList;
				var admissionNotificationsTableRows = "";
				for(var i in registeredEnquiryNumbers){
					admissionNotificationsTableRows = admissionNotificationsTableRows + "<tr><td>"+registeredEnquiryNumbers[i]+"</td><td></td></tr>";
				}
				$("#admissionNotifications").append(admissionNotificationsTableRows);
				$("#busyIndicator").hide();
			},function(error){
				
			});
		}, 4000);
		
	}
</script>
</head>
<body onload="initAdmissionNotifications();">
<a href="./EnquiryList">List All Addmission</a><br>
<a href="./addNewEnquiry.jsp">New Admission</a>
<center>
<h3>New registrations</h3>
<div id="busyIndicator"><img src="" alt='loading' /></div>

<table id="admissionNotifications">

</table>
</center>
</body>
</html>