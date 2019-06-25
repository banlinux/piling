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
<script type="text/javascript" src="js/master/pileMaster.js"></script>
<title>Piling Rig Progress</title>
<script type="text/javascript">
function autofill(){
	 var tType="CONTRACT";

	 $( "#contract_no" ).autocomplete({	    	
	        source: '${pageContext. request. contextPath}/pileMaster/pileMasterAjax.htm?senderType='+tType,
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
<div align="center"><h2>Pile Master</h2></div>
<spring:form commandName="pileMasterBean">
<div class="mainDiv">
 <fieldset class="dottedborder">
 <legend class="fieldsetheader"> Pile Detail</legend>
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
 		<td class="labeltext">Drawing No</td>
 		<td><spring:input path="drawing_no" /></td>
 	</tr>
 	 	 	<tr>
 		<td class="labeltext">Pile No</td>
 		<td><spring:input path="pile_no" /></td>
 		<td class="labeltext">Pile Dia</td>
 		<td><spring:input path="pile_dia" /></td>
 	</tr>
  	<tr>
 		<td class="labeltext">Cage Length</td>
 		<td><spring:input path="cage_length" /></td>
 		<td class="labeltext">Boring Length</td>
 		<td><spring:input path="boring_length" /></td>
 	</tr>
 	<tr>
 		<td class="labeltext">Concrete Volume</td>
 		<td><spring:input path="concrete_volume" /></td>
 		<td class="labeltext">Cage Detail</td>
 		<td><spring:input path="cage_detail" /></td>
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
</div>
</spring:form>
</body>
</html>