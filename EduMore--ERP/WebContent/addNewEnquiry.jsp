<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="./NewEnquiry" method="post">
<label> First Name</label>
<input type="text" name="firstName"></input>
<label>Middle Name</label>
<input type="text" name="middleName"></input>
<label>Last Name</label>
<input type="text" name="lastName"></input><br>
<label>Residence Number</label>
<input type="text" name="residenceNumber"></input>
<label>Mobile Number</label>
<input type="text" name="mobileNumber"></input><br>
<label>Email Id: </label>
<input type="text" name="email"></input><br>
<label> Father First Name</label>
<input type="text" name="fatherFirstName"></input>
<label>Father Middle Name</label>
<input type="text" name="fatherMiddleName"></input>
<label>Last Name</label>
<input type="text" name="fatherLastName"></input><br>
<label>Father Residence Number</label>
<input type="text" name="fatherResidenceNumber"></input>
<label>Father Mobile Number</label>
<input type="text" name="fatherMobileNumber"></input><br>
<label>Current Address</label><br>
<label>House/Flat/Block No.</label>
<input type="text" name="currentHouseNumber"></input>
<label>Building/Village/Premise</label>
<input type="text" name="currentBuilding"></input>
<label>Road/Street/ Post Office</label>
<input type="text" name="currentRoad"></input><br>
<label>Area Detail</label>
<input type="text" name="currentrArea"></input><br>
<label>District/Town/City</label>
<input type="text" name="currentCity"></input>
<label>State</label>
<input type="text" name="currentState"></input>
<label>Pincode</label>
<input type="text" name="currentPincode"></input><br>
<label>Permanent Address</label><br>
<label>House/Flat/Block No.</label>
<input type="text" name="permanentHouseNumber"></input>
<label>Building/Village/Premise</label>
<input type="text" name="permanentBuilding"></input>
<label>Road/Street/ Post Office</label>
<input type="text" name="permanentRoad"></input><br>
<label>Area Detail</label>
<input type="text" name="permanentrArea"></input><br>
<label>District/Town/City</label>
<input type="text" name="permanentCity"></input>
<label>State</label>
<input type="text" name="permanentState"></input>
<label>Pincode</label>
<input type="text" name="permanentPincode"></input><br>
<label>Gender</label>
<input type="text" name="gender"></input>
<label>D.O.B</label>
<input type="text" name="dateOfBirth"></input><br>

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
		<input type="text" name="qualification"></input>
	</td>
	<td>
		<input type="text" name="status"></input>
	</td>
	<td>
		<input type="text" name="schoolName"></input>
	</td>
	<td>
		<input type="text" name="board"></input>
	</td>
	<td>
		<input type="text" name="completedYear"></input>
	</td>
	<td>
		<input type="text" name="marksSecured"></input>
	</td>

	
</tr>
</tbody>
</table>
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

