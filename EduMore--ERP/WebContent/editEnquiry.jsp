
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.edumore.counsellor.bean.EnquiryBean"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script>
var educationNumber = 0;

$(document).ready(function(){
	$("#educationNumber").val(educationNumber);
    $("#addNewRow").click(function(){
    	educationNumber++;
        $("#educationDetails").append('<tr><td><input type="text" name="qualification_'+educationNumber+'"></input></td><td><input type="text" name="status_'+educationNumber+'"></input></td><td><input type="text" name="schoolName_'+educationNumber+'"></input></td><td><input type="text" name="board_'+educationNumber+'"></input></td><td><input type="text" name="completedYear_'+educationNumber+'"></input></td><td><input type="text" name="marksSecured_'+educationNumber+'"></input></td></tr>');
        $("#educationNumber").val(educationNumber);
        
    });
});
</script>
</head>
<body>
<% EnquiryBean bean = (EnquiryBean)request.getAttribute("enquiry");%>
<form action="./NewEnquiry" method="post">
<input type="hidden" value="updateEnquiry" name="action"/>
<input type="text" value=<%= bean.getEnquiryNumber()  %> name="enquiryNumber"/>
<input type="text" value=<%= bean.getEnquiry_id()  %> name="enquiryId"/>
<label> First Name</label>
<input type="text" name="firstName" value=<%= bean.getFirstName()  %>></input>
<label>Middle Name</label>
<input type="text" name="middleName" value=<%= bean.getMiddleName()  %>></input>
<label>Last Name</label>
<input type="text" name="lastName" value=<%= bean.getLastName()  %>></input><br>
<label>Residence Number</label>
<input type="text" name="residenceNumber" value=<%= bean.getResidenceNumber()  %>></input>
<label>Mobile Number</label>
<input type="text" name="mobileNumber" value=<%= bean.getMobileNumber()  %>></input><br>
<label>Email Id: </label>
<input type="text" name="email" value=<%= bean.getEmailId()  %>></input><br>
<label> Father First Name</label>
<input type="text" name="fatherFirstName" value=<%= bean.getFatherFirstName()  %>></input>
<label>Father Middle Name</label>
<input type="text" name="fatherMiddleName" value=<%= bean.getFatherMiddleName()  %>></input>
<label>Father Last Name</label>
<input type="text" name="fatherLastName" value=<%= bean.getFatherLastName()  %>></input><br>
<label>Father Residence Number</label>
<input type="text" name="fatherResidenceNumber" value=<%= bean.getFatherResidenceNumber()  %>></input>
<label>Father Mobile Number</label>
<input type="text" name="fatherMobileNumber" value=<%= bean.getFatherMobileNumber()  %>></input><br>
<label>Current Address</label><br>
<label>House/Flat/Block No.</label>
<input type="text" name="currentHouseNumber" value=<%= bean.getCurrentAddress().getHouseNumber()  %>></input>
<label>Building/Village/Premise</label>
<input type="text" name="currentBuilding" value=<%= bean.getCurrentAddress().getBuildingName()  %>></input>
<label>Road/Street/ Post Office</label>
<input type="text" name="currentRoad" value=<%= bean.getCurrentAddress().getRoadName()  %>></input><br>
<label>Area Detail</label>
<input type="text" name="currentrArea" value=<%= bean.getCurrentAddress().getAreaDetail()  %>></input><br>
<label>District/Town/City</label>
<input type="text" name="currentCity" value=<%= bean.getCurrentAddress().getCity()  %>></input>
<label>State</label>
<input type="text" name="currentState" value=<%= bean.getCurrentAddress().getState()  %>></input>
<label>Pincode</label>
<input type="text" name="currentPincode" value=<%= bean.getCurrentAddress().getPincode()  %>></input><br>
<label>Permanent Address</label><br>
<label>House/Flat/Block No.</label>
<input type="text" name="permanentHouseNumber" value=<%= bean.getPermanentAddress().getHouseNumber()  %>></input>
<label>Building/Village/Premise</label>
<input type="text" name="permanentBuilding" value=<%= bean.getPermanentAddress().getBuildingName() %>></input>
<label>Road/Street/ Post Office</label>
<input type="text" name="permanentRoad" value=<%= bean.getPermanentAddress().getRoadName()  %>></input><br>
<label>Area Detail</label>
<input type="text" name="permanentArea" value=<%= bean.getPermanentAddress().getAreaDetail()  %>></input><br>
<label>District/Town/City</label>
<input type="text" name="permanentCity" value=<%= bean.getPermanentAddress().getCity()  %>></input>
<label>State</label>
<input type="text" name="permanentState" value=<%= bean.getPermanentAddress().getState()  %>></input>
<label>Pincode</label>
<input type="text" name="permanentPincode" value=<%= bean.getPermanentAddress().getPincode()  %>></input><br>
<label>Gender</label>
<input type="text" name="gender" value=<%= bean.getGender() %>></input>
<label>D.O.B</label>
<input type="text" name="dateOfBirth" value=<%= bean.getDateOfBirth() %>></input><br>

<table>
<thead>
<tr>
	<td>
		Qualification
	</td>
	<td>
		Completed/Pursuing
	</td>
	<td>
		School/ College
	</td>
	<td>
		Board / University
	</td>
	<td>
		Exp. / Completed Year
	</td>
	<td>
		Grade/ % marks
	</td>
	
</tr>
</thead>

<tbody>
<tr>
	<td>
		<input type="text" name="qualification_0"></input>
	</td>
	<td>
		<input type="text" name="status_0"></input>
	</td>
	<td>
		<input type="text" name="schoolName_0"></input>
	</td>
	<td>
		<input type="text" name="board_0"></input>
	</td>
	<td>
		<input type="text" name="completedYear_0"></input>
	</td>
	<td>
		<input type="text" name="marksSecured_0"></input>
	</td>

	
</tr>
</tbody>
</table><a href="javascript:void(0);" id="addNewRow">Add New row</a><input type="hidden" id="educationNumber" name="educationNumber" value=educationNumber></input>
<br>
<label>Details of IT Program done</label><br>
<label>Program</label>
<input type="text" name="programName"></input>
<label>Nature Of Program</label>
<input type="text" name="natureOfProgram"></input>
<label>Institute</label>
<input type="text" name="institute"></input>
<label>Year</label>
<input type="text" name="year"></input><br>
<label>Working Experience</label><br>
<label>Status</label>
<input type="text" name="workingStatus"></input><br>
<label>Name of the present organization</label>
<input type="text" name="organisationName"></input>
<label>Designation</label>
<input type="text" name="designation"></input><br>
<label>Total Experience</label>
<input type="text" name="totalExperience"></input>

<label>Nature Of Job</label>
<input type="text" name="natureOfJob"></input>
<label>Salary</label>
<input type="text" placeholder="in Month" name="salary"></input><br>
<label>Address of the organization</label>
<input type="text" name="organizationAddress"></input><br>
<label>URL</label>
<input type="text" name="url"></input>
<label>Office Contact Number</label>
<input type="text" name="officeNumber"></input>
<label>Email Id</label>
<input type="text" name="officeEmail"></input><br>
<label>Career Preference</label>
<input type="text" name="careerPreference"></input>
<label>Program Preference</label>
<input type="text" name="programPreference"></input><br>




<input type="submit"></input>

</form>


${statusMsg}
</body>
</html>

