<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">

<html xmlns="http://www.w3.org/1999/xhtml"><head id="Head1"><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><title>
	User Login
</title><link href="./User Login_files/style.css" rel="stylesheet" type="text/css">
    <style type="text/css">
        .style1
        {
            text-decoration: none;
        }
    </style>
    </head>
<body>
   <form action="./Login" method="post">
<div>
<input type="hidden" name="__EVENTTARGET" id="__EVENTTARGET" value="">
<input type="hidden" name="__EVENTARGUMENT" id="__EVENTARGUMENT" value="">
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="/wEPDwULLTE3NDMzOTI2NzRkZLAQk6AuNeippj0qawmlJGNAG5XS">
</div>

<script type="text/javascript">
//<![CDATA[
var theForm = document.forms['form1'];
if (!theForm) {
    theForm = document.form1;
}
function __doPostBack(eventTarget, eventArgument) {
    if (!theForm.onsubmit || (theForm.onsubmit() != false)) {
        theForm.__EVENTTARGET.value = eventTarget;
        theForm.__EVENTARGUMENT.value = eventArgument;
        theForm.submit();
    }
}
//]]>
</script>


<script src="./User Login_files/WebResource.axd" type="text/javascript"></script>


<script src="./User Login_files/WebResource(1).axd" type="text/javascript"></script>
<script type="text/javascript">
//<![CDATA[
function WebForm_OnSubmit() {
if (typeof(ValidatorOnSubmit) == "function" && ValidatorOnSubmit() == false) return false;
return true;
}
//]]>
</script>

<div>

	<input type="hidden" name="__EVENTVALIDATION" id="__EVENTVALIDATION" value="/wEWBwLWj8neBgKbzeDYCQLluK7bCQLcjd7CBAL+hcPxBwL3jKLTDQLcu4S2BHwKdhzE341mYMAlxbtei1FBIFoc">
</div>
  
     <div class="main_wrap">
  <div class="main">
    <div class="main_wrap">
      <div class="top_area">
        <div class="top_area_main">
          <div class="logo_area">
            <div class="main_wrap">
              <div class="logo_pasition"><img src="./User Login_files/logo.gif" alt=""></div>
            </div>
          </div>
         
        </div>
      </div>
     
      <div class="welcome_area" style="margin-top: 50px;">
        <div class="main_wrap">
          <div class="welcome_main">
            <div class="main_wrap">
              <p class="welcome_text">eMPOWER</p>
                <p style="padding:0 0 6px 0;">Edumore Learning takes students to the core of IT fundamentals and 
                    the most advanced cutting-edge technology. Its course modules are structured to 
                    give you the best of both worlds, academic and hands-on. </p>
                <p style="padding:0 0 6px 0;">Whether you are a beginner or a working professional, 
                    Edumore Learning can make a difference to your learning curve and thereby to your earning 
                    curve.</p>
             <p style="padding:8px 0 16px 0;"></p>
            </div>
          </div>
        </div>
      </div>
      <br class="blank">
      <div class="welcome_area">
        <div class="welcome_main">
          <div class="main_wrap">
            <div class="left_body_area">
              <div class="main_wrap">
                <div class="left_main">
                  <div class="main_wrap">
                  <div id="content">
			<ul><li>
					<label for="username">User Name</label>
                    <input name="username" type="text" id="unameTextBox" accesskey="n" tabindex="1">
					
				    <span id="RequiredFieldValidator1" style="color:Red;visibility:hidden;">*</span>
				</li>
				<li>
					<label for="password">Password </label>
                         <input name="password" type="password" id="upassTextBox" accesskey="n" tabindex="2">
					
				    <span id="RequiredFieldValidator2" style="color:Red;visibility:hidden;">*</span>
				</li>
				<li>
				<label style="color:${loginStatusMsgColor}">${loginStatusMessage}</label>
				</li>
				
			</ul>
                 <div class="style1">
                       
              <span id="RequiredFieldValidator3" style="color:Red;visibility:hidden;">*</span>  <strong>  <span id="Label1"></span>
                     </strong></div>
			<div id="buttons">
                <input type="submit" name="submit" value="Login" id="submit">
               	

			</div>
		</div>
                  </div>
                </div>
              </div>
            </div>
            <div class="right_body_area">
              <div class="trust_text">Information PANE</div>
              <div class="main_wrap">
                <div class="divider_place">
                  <div class="trust_left_area">
                    <div class="main_wrap">
                      <div class="man2"><img src="./User Login_files/pin.png" alt=""></div>
                      <div class="man1">
                        <p class="panling_text">We believe !</p>
                        <p style=" padding:0 5px 0 0;">As the fountainhead of the most significant pursuit of human mind, Edumore Learning believes, only a leader can transform you into a leader. Edumore Learning is an initiative that enables individuals to benefit from Edumore Learning expertise in the space and become Industry ready IT professionals..... </p>
                        <p style="padding:8px 0 16px 0;"></p>
                      </div>
                      <div class="black"></div>
                    </div>
                  </div>
                  <div class="trust_meddile_area">&nbsp;</div>
                  <div class="trust_left_area">
                    <div class="main_wrap">
                      <div class="box_area">
                        <div class="main_wrap">
                          <div class="icon"><img src="./User Login_files/book.png" alt=""></div>
                          <div class="icon1">
                            <p class="panling_text">Edumore Learning</p>
                            <p style=" padding:0 5px 0 0;">As the training arm of Edumore Learning Infosystems, Edumore Learning Career Development Centre (CDC) carries forth a legacy of excellence spanning across more than three decades. Edumore Learning is an initiative that enables individuals and organisations to benefit from Edumore Learning's deep expertise in the IT space.</p>
                            <p style="padding:8px 0 16px 0;"></p>
                          </div>
                          <div class="black"></div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="black"></div>
                </div>
              </div>
              <div class="ass_divider_botm"></div>
              
            </div>
          </div>
          <div class="black"></div>
        </div>
      </div>
   
        <div id="ValidationSummary1" style="color:Red;display:none;">

</div>
   
      </div>
      <div class="main">
        <div class="footer_area">
        Copyright 2014 @ Edumore Learning&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;      
               
        </div>
      </div>
  
   
  </div>
  </div>
         
<script type="text/javascript">
//<![CDATA[
var Page_ValidationSummaries =  new Array(document.getElementById("ValidationSummary1"));
var Page_Validators =  new Array(document.getElementById("RequiredFieldValidator1"), document.getElementById("RequiredFieldValidator2"), document.getElementById("RequiredFieldValidator3"));
//]]>
</script>

<script type="text/javascript">
//<![CDATA[
var RequiredFieldValidator1 = document.all ? document.all["RequiredFieldValidator1"] : document.getElementById("RequiredFieldValidator1");
RequiredFieldValidator1.controltovalidate = "unameTextBox";
RequiredFieldValidator1.errormessage = "Username Required";
RequiredFieldValidator1.evaluationfunction = "RequiredFieldValidatorEvaluateIsValid";
RequiredFieldValidator1.initialvalue = "";
var RequiredFieldValidator2 = document.all ? document.all["RequiredFieldValidator2"] : document.getElementById("RequiredFieldValidator2");
RequiredFieldValidator2.controltovalidate = "upassTextBox";
RequiredFieldValidator2.errormessage = "Password Required";
RequiredFieldValidator2.evaluationfunction = "RequiredFieldValidatorEvaluateIsValid";
RequiredFieldValidator2.initialvalue = "";
var RequiredFieldValidator3 = document.all ? document.all["RequiredFieldValidator3"] : document.getElementById("RequiredFieldValidator3");
RequiredFieldValidator3.controltovalidate = "RadioButtonList1";
RequiredFieldValidator3.focusOnError = "t";
RequiredFieldValidator3.errormessage = "Select Server Type";
RequiredFieldValidator3.evaluationfunction = "RequiredFieldValidatorEvaluateIsValid";
RequiredFieldValidator3.initialvalue = "";
var ValidationSummary1 = document.all ? document.all["ValidationSummary1"] : document.getElementById("ValidationSummary1");
ValidationSummary1.showmessagebox = "True";
ValidationSummary1.showsummary = "False";
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
        //]]>
</script>
</form>

</body></html>