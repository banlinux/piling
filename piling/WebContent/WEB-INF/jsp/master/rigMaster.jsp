<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../menu/commonHead.jsp"></jsp:include>
<link rel="stylesheet" href="css/piling.css">
<script type="text/javascript" src="js/pilingRigProgressForm/pilingRigProgress.js"></script>
<script type="text/javascript" src="js/pilingRigProgressForm/ajax.js"></script>
<script language="javascript" src="js/common/table_creation_api.js"></script>
<script type="text/javascript" src="js/master/rigMaster.js"></script>
<title>Piling Rig Progress</title>
<script type="text/javascript">
function autofill(){
	 var tType="CONTRACT";

	 $( "#contract_no" ).autocomplete({	    	
	        source: '${pageContext. request. contextPath}/rigMaster/rigMasterAjax.htm?senderType='+tType,
	        minLength: 3,
	        select: function(e, ui) {
	      
	        	getContractDetails(ui.item.value);
	        	
  	  }
    });
}
</script>
<style type="text/css">
<!--
.style6 {
	color: #666666
}

.style7 {
	color: #FF0000
}

.style8 {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 11px;
}

.style9 {
	font-size: 12px
}
</style>
</head>
<body>
<div style="height: 100px"><jsp:include page="../menu${sessUserID}.jsp" ></jsp:include></div> 
<div align="center"><h2>Piling Rig Master</h2></div>
<spring:form commandName="rigMasterBean">
<div class="mainDiv">
 <fieldset class="dottedborder">
 <legend class="fieldsetheader"> Rig Detail</legend>
 <table>
 	<tr>
 		<td class="labeltext">Select Contract</td>
 		<td><spring:input path="contract_no" onkeyup="autofill();"   size="30"/>
 			<spring:errors path="contract_no" cssClass="error"></spring:errors>
  		</td>
 		<td><spring:input path="contractName" size="120"/> </td>
 		<td></td>
 	</tr>
 </table>
 <table>	
 	<tr>
 		<td class="labeltext">Site Code</td>
 		<td><spring:input path="site_no" /></td>
 		<td class="labeltext">Rig No</td>
 		<td><spring:input path="rig_sl_no" /></td>
 	</tr>	
 	 	<tr>
 		<td class="labeltext">RFID Code</td>
 		<td><spring:input path="rfif_code" /></td>
 		<td class="labeltext">Machine</td>
 		<td><spring:input path="machine_code" /></td>
 	</tr>
  	<tr>
 		<td class="labeltext">Rig Name</td>
 		<td><spring:input path="rig_name" /></td>
 		<td class="labeltext">Rig Make</td>
 		<td><spring:input path="rig_make" /></td>
 	</tr>
 	<tr>
 		<td class="labeltext">Rig Model</td>
 		<td><spring:input path="rig_model" /></td>
 		<td class="labeltext">Rig Capacity</td>
 		<td><spring:input path="rig_capacity" /></td>
 	</tr>
 	<tr>
 		<td class="labeltext">Rig Mfg. Year</td>
 		<td><spring:input path="rig_yom" /></td>
 		<td class="labeltext">Rig Installation Date</td>
 		 				<td align="left"><spring:input path="rig_installation_date" readonly="true" tabindex="-1"/><A
					HREF='javascript:showCalendarControl (document.forms[0].rig_installation_date)'>
						<IMG src="js/calendar/calendar1.gif" border=0 align=middle>
				</A>  </td>
 
 	</tr>
 	<tr>
 		<td class="labeltext">Rig Release Date</td>
 			 				<td align="left"><spring:input path="rig_release_date" readonly="true" tabindex="-1"/><A
					HREF='javascript:showCalendarControl (document.forms[0].rig_release_date)'>
						<IMG src="js/calendar/calendar1.gif" border=0 align=middle>
				</A>  </td>

 		<td class="labeltext1">Remark</td>
 		<td><spring:input path="remark"  /></td>
 	</tr> 		
 </table>
  <table width="60%">
			<tr>
				<td>	
					<input type="reset" class="button1" name="Reset" value="Reset">&nbsp;&nbsp;		
					<input type="submit" class="button1" name="_save" id="_save" value="Add">						
					<input type="submit" class="button1" name="_delete" id="_delete" value="Delete">&nbsp;&nbsp;
											
					</td>
			</tr>
		</table>
 </fieldset>
 <table id="result"></table>
 </div>
 </spring:form>
</html>