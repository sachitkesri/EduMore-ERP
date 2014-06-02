<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html><head><title>
	Counsellor Home
</title><link href="./css/NewStyleSheet.css" rel="stylesheet" type="text/css">
<script>

function loadAllEnquiries(){
	$.ajax("./EnquiryList", {
        beforeSend: function(req) {
            req.setRequestHeader("Accept", "text/html;type=ajax");
        },  
        complete : function(jqXHR){
        	<%@ include file="/enquirylist.jsp" %>
          //  $("#objectViewer").html(jqXHR.responseText);
        }
    });
};

</script></head>

<body>
  
<center>
    <div class="headmemspot">
       Counsellor Home</div>
    <div class="divmiddle2">
        <div class="divmiddle1">
            
<table border="0" cellpadding="1" cellspacing="7">
    <tbody><tr>
        <td style="width:30px;text-align:center">
            <input type="image" name="ButtonControl_Report1$addImageButton" id="ButtonControl_Report1_addImageButton" disabled="disabled" title="ADD" src="./images/bt_add.jpg" style="border-width:0px;cursor: hand;">
        </td>
        <td style="width:30px;text-align:center">
            <input type="image" name="ButtonControl_Report1$editImageButton" id="ButtonControl_Report1_editImageButton" disabled="disabled" title="EDIT" src="./images/bt_edit.jpg" style="border-width:0px;cursor: hand;">
        </td>
        <td style="width:30px;text-align:center">
            <input type="image" name="ButtonControl_Report1$saveImageButton" id="ButtonControl_Report1_saveImageButton" title="SAVE" src="./images/bt_save.png" onclick="javascript:WebForm_DoPostBackWithOptions(new WebForm_PostBackOptions(&quot;ButtonControl_Report1$saveImageButton&quot;, &quot;&quot;, true, &quot;&quot;, &quot;&quot;, false, false))" style="border-width:0px;cursor: hand;">
        </td>
        <td style="width:30px;text-align:center">
            <input type="image" name="ButtonControl_Report1$deleteImageButton" id="ButtonControl_Report1_deleteImageButton" disabled="disabled" title="DELETE" src="./images/bt_delete.png" style="border-width:0px;cursor: hand;">
        </td>
        <td style="width:30px;text-align:center">
            <input type="image" name="ButtonControl_Report1$listImageButton" id="ButtonControl_Report1_listImageButton" title="LIST" src="./images/bt_list.jpg" onclick="javascript:loadAllEnquiries()" style="border-width:0px;cursor: hand">
        </td>
       
        <td style="width:30px;text-align:center">
            <input type="image" name="ButtonControl_Report1$resetImageButton" id="ButtonControl_Report1_resetImageButton" title="RESET" src="./images/bt_reset.jpg" onclick="return confirm(&quot;Are your sure?&quot;);" style="border-width:0px;cursor: hand;">
        </td>
    </tr>
    <tr>
        <td style="width:30px;text-align:center">
            <small>Add</small>
        </td>
        <td style="width:30px;text-align:center">
            <small>Edit</small>
        </td>
        <td style="width:30px;text-align:center">
            <small>
                <span id="ButtonControl_Report1_saveButtonText">Excel</span></small>
        </td>
        <td style="width:30px;text-align:center">
            <small>Delete</small>
        </td>
        <td style="width:30px;text-align:center">
            <small>List</small>
        </td>
       
        <td style="width:30px;text-align:center">
            <small>Reset</small>
        </td>
    </tr>
</tbody></table>

<table style="border-style: none; border-color: inherit; border-width: 0px; position: relative; left: 2px; width: 400px" cellpadding="0">
    
    <tbody><tr align="left">
        <td style="width: 120px" valign="top">
            
        </td>
        <td valign="top">
            
        </td>
    </tr>
    <tr align="left" valign="top">
        <td>Centre 
        </td>
        <td valign="top">
            <select name="ButtonControl_Report1$CentreDropDownList" id="ButtonControl_Report1_CentreDropDownList" class="forTextBox">
	<option selected="selected" value="624">Sahibabad</option>

</select>
            <span id="ButtonControl_Report1_CompareValidator1" style="color:Red;visibility:hidden;">*</span>
        </td>
    </tr>

</tbody></table>
<input type="hidden" name="ButtonControl_Report1$user_HiddenField1" id="ButtonControl_Report1_user_HiddenField1" value="624acdmc">


            <table>
                <tbody><tr>
                    <td style="width: 120px">
                        Course Ware Type<span id="CompareValidator2" style="color:Red;visibility:hidden;">*</span>
                    </td>
                    <td>
                        <select name="categoryDropDownList" id="categoryDropDownList" class="forTextBox" style="width:100px;height: 18px">
	<option value="Select">Select</option>
	<option value="Books">Books</option>
	<option value="Kits">Kits</option>
	<option value="Hardware">Hardware</option>

</select>
                    </td>
                </tr>
                <tr>
                    <td>
                        Reg. From Date<span id="RequiredFieldValidator1" style="color:Red;visibility:hidden;">*</span>
                    </td>
                    <td>
                        <input name="Date1TextBox" type="text" value="02/06/2014" id="Date1TextBox" class="forTextBox" style="width:137px;">
                        Reg. To Date<span id="RequiredFieldValidator2" style="color:Red;visibility:hidden;">*</span>
                        <input name="Date2TextBox" type="text" value="02/06/2014" id="Date2TextBox" class="forTextBox" style="width:137px;">
                    </td>
                </tr>
                <tr>
                    <td>
                        Material Due Date<span id="RequiredFieldValidator3" style="color:Red;visibility:hidden;">*</span>
                    </td>
                    <td>
                        <input name="Date3TextBox" type="text" id="Date3TextBox" class="forTextBox" style="width:137px;">
                        <br>
                        
                        
                        
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div id="ValidationSummary1" style="color:Red;display:none;">

</div>
                    </td>
                </tr>
            </tbody></table>
            
      
        </div>
    </div>
 </center>   
<!-- <script type="text/javascript">
//<![CDATA[
var Page_ValidationSummaries =  new Array(document.getElementById("ValidationSummary1"));
var Page_Validators =  new Array(document.getElementById("ButtonControl_Report1_CompareValidator1"), document.getElementById("CompareValidator2"), document.getElementById("RequiredFieldValidator1"), document.getElementById("RequiredFieldValidator2"), document.getElementById("RequiredFieldValidator3"));
//]]>
</script>

<script type="text/javascript">
//<![CDATA[
var ButtonControl_Report1_CompareValidator1 = document.all ? document.all["ButtonControl_Report1_CompareValidator1"] : document.getElementById("ButtonControl_Report1_CompareValidator1");
ButtonControl_Report1_CompareValidator1.controltovalidate = "ButtonControl_Report1_CentreDropDownList";
ButtonControl_Report1_CompareValidator1.errormessage = "Select Centre";
ButtonControl_Report1_CompareValidator1.evaluationfunction = "CompareValidatorEvaluateIsValid";
ButtonControl_Report1_CompareValidator1.valuetocompare = "0";
ButtonControl_Report1_CompareValidator1.operator = "NotEqual";
var CompareValidator2 = document.all ? document.all["CompareValidator2"] : document.getElementById("CompareValidator2");
CompareValidator2.controltovalidate = "categoryDropDownList";
CompareValidator2.errormessage = "Select Category";
CompareValidator2.evaluationfunction = "CompareValidatorEvaluateIsValid";
CompareValidator2.valuetocompare = "Select";
CompareValidator2.operator = "NotEqual";
var RequiredFieldValidator1 = document.all ? document.all["RequiredFieldValidator1"] : document.getElementById("RequiredFieldValidator1");
RequiredFieldValidator1.controltovalidate = "Date1TextBox";
RequiredFieldValidator1.errormessage = "Please Select From Date";
RequiredFieldValidator1.evaluationfunction = "RequiredFieldValidatorEvaluateIsValid";
RequiredFieldValidator1.initialvalue = "";
var RequiredFieldValidator2 = document.all ? document.all["RequiredFieldValidator2"] : document.getElementById("RequiredFieldValidator2");
RequiredFieldValidator2.controltovalidate = "Date2TextBox";
RequiredFieldValidator2.errormessage = "Please Select To Date";
RequiredFieldValidator2.evaluationfunction = "RequiredFieldValidatorEvaluateIsValid";
RequiredFieldValidator2.initialvalue = "";
var RequiredFieldValidator3 = document.all ? document.all["RequiredFieldValidator3"] : document.getElementById("RequiredFieldValidator3");
RequiredFieldValidator3.controltovalidate = "Date3TextBox";
RequiredFieldValidator3.errormessage = "Please Select Due Date";
RequiredFieldValidator3.evaluationfunction = "RequiredFieldValidatorEvaluateIsValid";
RequiredFieldValidator3.initialvalue = "";
//]]>
</script>


<script type="text/javascript">
//<![CDATA[

var Page_ValidationActive = false;
if (typeof(ValidatorOnLoad) == "function") {
    ValidatorOnLoad();
}

function ValidatorOnSubmit() {
    if (Page_ValidationActive) {
        return ValidatorCommonOnSubmit();
    }
    else {
        return true;
    }
}
        
document.getElementById('ValidationSummary1').dispose = function() {
    Array.remove(Page_ValidationSummaries, document.getElementById('ValidationSummary1'));
}
Sys.Application.initialize();

document.getElementById('ButtonControl_Report1_CompareValidator1').dispose = function() {
    Array.remove(Page_Validators, document.getElementById('ButtonControl_Report1_CompareValidator1'));
}

document.getElementById('CompareValidator2').dispose = function() {
    Array.remove(Page_Validators, document.getElementById('CompareValidator2'));
}

document.getElementById('RequiredFieldValidator1').dispose = function() {
    Array.remove(Page_Validators, document.getElementById('RequiredFieldValidator1'));
}

document.getElementById('RequiredFieldValidator2').dispose = function() {
    Array.remove(Page_Validators, document.getElementById('RequiredFieldValidator2'));
}

document.getElementById('RequiredFieldValidator3').dispose = function() {
    Array.remove(Page_Validators, document.getElementById('RequiredFieldValidator3'));
}
Sys.Application.add_init(function() {
    $create(Sys.Extended.UI.CalendarBehavior, {"format":"dd/MM/yyyy","id":"CalendarExtender3"}, null, null, $get("Date3TextBox"));
});
Sys.Application.add_init(function() {
    $create(Sys.Extended.UI.CalendarBehavior, {"format":"dd/MM/yyyy","id":"CalendarExtender1"}, null, null, $get("Date1TextBox"));
});
Sys.Application.add_init(function() {
    $create(Sys.Extended.UI.CalendarBehavior, {"format":"dd/MM/yyyy","id":"CalendarExtender2"}, null, null, $get("Date2TextBox"));
});
//]]>
</script>
 -->


</body></html>